-- Populando a tabela cliente
INSERT INTO cliente (login, email, nome, senha) VALUES
                                                    ('usuario1', 'usuario1@email.com', 'Usuário Um', 'senha123'),
                                                    ('usuario2', 'usuario2@email.com', 'Usuário Dois', 'senha456');

-- Populando a tabela organizador
INSERT INTO organizador (login, email, nome, senha) VALUES
                                                        ('org1', 'org1@email.com', 'Organizador Um', 'senha789'),
                                                        ('org2', 'org2@email.com', 'Organizador Dois', 'senha101');

-- Populando a tabela evento
INSERT INTO evento (capacidade_max,  horario, descricao, local, nome) VALUES
                                                                               (100, '18:00:00', 'Show de Rock', 'Arena Central', 'Festival de Música'),
                                                                               (50 , '20:30:00', 'Palestra de Tecnologia', 'Auditório A', 'Tech Summit');

