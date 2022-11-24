INSERT INTO USERS (email, name, password, phone, point, membership, created_at, updated_at)
VALUES ('test@gmail.com', '테스트', 'test1234', '010-0000-0000', 1195, 'DIAMOND', current_time, current_time);

INSERT INTO ITEMS
    (created_at, updated_at, name, price, stock, category,origin)
VALUES (current_time, current_time, '커피', 1500, 100, 'COFFEE', '케냐');
INSERT INTO ITEMS
(created_at, updated_at, name, price, stock, category, shelf_life_date)
VALUES (current_time, current_time, '블루베리 케이크', 5000, 3, 'FOOD', TIMESTAMPADD(DAY, 2, NOW()))
