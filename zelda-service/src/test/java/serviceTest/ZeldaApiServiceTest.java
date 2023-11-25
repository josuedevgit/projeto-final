package serviceTest;

import com.projetofinal.zeldaservice.model.JogoZelda;
import com.projetofinal.zeldaservice.service.ZeldaApiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZeldaApiServiceTest {
    @Mock
    private RestTemplate restTemplate = new RestTemplate();
    @InjectMocks
    private ZeldaApiService zeldaApiService;

    private final String apiUrl = "https://zelda.fanapis.com/api/games";

    @Test
    void getJogosTest() {
        JogoZelda[] mockResponse;

        Map<String, String> params = new HashMap<>();
        params.put("limit", "1");
        params.put("page", "0");
        params.put("name", "Zelda");

        String urlComParametros = this.apiUrl + "?limit={limit}&page={page}&name={name}";

        mockResponse = restTemplate.getForObject(urlComParametros, JogoZelda[].class, params);

        JogoZelda[] response = zeldaApiService.getJogos("1", "0", "Zelda");
        assertArrayEquals(mockResponse, response);
    }
}
