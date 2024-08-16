--JSON INSERT
[
    {
        "name": "Arroz Integral",
        "qtdProteina": "2.6g",
        "qtdCarbo": "23g",
        "caloria": "110",
        "qtdGordura": 0.9,
        "qtdFibra": 1.8,
        "qtdSodio": 0.0,
        "qtdAcucares": 0.0,
        "categoria": "CARBOIDRATOS",
        "porcao": 50.0,
        "medidaCaseira": "1/4 xícara"
    },
    {
        "name": "Peito de Frango",
        "qtdProteina": "31g",
        "qtdCarbo": "0g",
        "caloria": "165",
        "qtdGordura": 3.6,
        "qtdFibra": 0.0,
        "qtdSodio": 74.0,
        "qtdAcucares": 0.0,
        "categoria": "PROTEINAS",
        "porcao": 100.0,
        "medidaCaseira": "1 filé médio"
    },
    {
        "name": "Abacate",
        "qtdProteina": "2g",
        "qtdCarbo": "9g",
        "caloria": "160",
        "qtdGordura": 15.0,
        "qtdFibra": 7.0,
        "qtdSodio": 7.0,
        "qtdAcucares": 0.7,
        "categoria": "GORDURAS",
        "porcao": 100.0,
        "medidaCaseira": "1/2 unidade"
    },
    {
        "name": "Leite Desnatado",
        "qtdProteina": "8g",
        "qtdCarbo": "12g",
        "caloria": "90",
        "qtdGordura": 0.2,
        "qtdFibra": 0.0,
        "qtdSodio": 120.0,
        "qtdAcucares": 12.0,
        "categoria": "LATICINIOS",
        "porcao": 200.0,
        "medidaCaseira": "1 copo"
    },
    {
        "name": "Brócolis",
        "qtdProteina": "3g",
        "qtdCarbo": "7g",
        "caloria": "55",
        "qtdGordura": 0.6,
        "qtdFibra": 2.6,
        "qtdSodio": 33.0,
        "qtdAcucares": 1.5,
        "categoria": "VEGETAIS",
        "porcao": 100.0,
        "medidaCaseira": "1 xícara"
    },
    {
        "name": "Banana",
        "qtdProteina": "1.3g",
        "qtdCarbo": "27g",
        "caloria": "105",
        "qtdGordura": 0.3,
        "qtdFibra": 3.1,
        "qtdSodio": 1.0,
        "qtdAcucares": 14.0,
        "categoria": "FRUTAS",
        "porcao": 120.0,
        "medidaCaseira": "1 unidade média"
    },
    {
        "name": "Feijão Preto",
        "qtdProteina": "9g",
        "qtdCarbo": "23g",
        "caloria": "132",
        "qtdGordura": 0.5,
        "qtdFibra": 7.5,
        "qtdSodio": 1.0,
        "qtdAcucares": 0.3,
        "categoria": "LEGUMINOSAS",
        "porcao": 100.0,
        "medidaCaseira": "1/2 xícara"
    },
    {
        "name": "Nozes",
        "qtdProteina": "4.3g",
        "qtdCarbo": "14g",
        "caloria": "185",
        "qtdGordura": 18.5,
        "qtdFibra": 2.0,
        "qtdSodio": 1.0,
        "qtdAcucares": 1.0,
        "categoria": "OLEAGINOSAS",
        "porcao": 28.0,
        "medidaCaseira": "1/4 xícara"
    }
]

--SQL INSERT
INSERT INTO tb_alimentos (name, qtd_proteina, qtd_carbo, caloria, qtd_gordura, qtd_fibra, qtd_sodio, qtd_acucares, categoria, porcao, medida_caseira)
VALUES
('Arroz Integral', '2.6g', '23g', '110', 0.9, 1.8, 0.0, 0.0, 'CARBOIDRATOS', 50.0, '1/4 xícara'),
('Peito de Frango', '31g', '0g', '165', 3.6, 0.0, 74.0, 0.0, 'PROTEINAS', 100.0, '1 filé médio'),
('Abacate', '2g', '9g', '160', 15.0, 7.0, 7.0, 0.7, 'GORDURAS', 100.0, '1/2 unidade'),
('Leite Desnatado', '8g', '12g', '90', 0.2, 0.0, 120.0, 12.0, 'LATICINIOS', 200.0, '1 copo'),
('Brócolis', '3g', '7g', '55', 0.6, 2.6, 33.0, 1.5, 'VEGETAIS', 100.0, '1 xícara'),
('Banana', '1.3g', '27g', '105', 0.3, 3.1, 1.0, 14.0, 'FRUTAS', 120.0, '1 unidade média'),
('Feijão Preto', '9g', '23g', '132', 0.5, 7.5, 1.0, 0.3, 'LEGUMINOSAS', 100.0, '1/2 xícara'),
('Nozes', '4.3g', '14g', '185', 18.5, 2.0, 1.0, 1.0, 'OLEAGINOSAS', 28.0, '1/4 xícara');

