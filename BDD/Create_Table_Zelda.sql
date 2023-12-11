CREATE TABLE zelda(
   id             VARCHAR(55) NOT NULL PRIMARY KEY
  ,nome           VARCHAR(255) NOT NULL
  ,descricao      VARCHAR(1500)
  ,desenvolvedor  VARCHAR(15) NOT NULL
  ,publicante     VARCHAR(15) NOT NULL
  ,dataLancamento DATE  NOT NULL
);