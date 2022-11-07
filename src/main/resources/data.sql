INSERT INTO USERS (email, name, password, phone, point, rank, created_at, updated_at)
VALUES ('test@gmail.com', '테스트', 'test1234', '010-0000-0000', 0, 'silver', current_time, current_time);

INSERT INTO ITEMS
    (created_at, updated_at, category, name, price, stock)
VALUES (current_time, current_time, 'COFFEE', '커피', 1500, 100);
INSERT INTO ITEMS
    (created_at, updated_at, category, name, price, stock)
VALUES (current_time, current_time, 'FOOD', '블루베리 케이크', 5000, 100)