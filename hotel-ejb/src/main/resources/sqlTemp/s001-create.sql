CREATE DATABASE IF NOT EXISTS hotel_core
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE hotel_core;


-- Таблица гостей
CREATE TABLE IF NOT EXISTS guests (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      last_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    INDEX idx_name (last_name, first_name)
    );

-- Таблица отелей
CREATE TABLE IF NOT EXISTS hotels (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR(200) NOT NULL,
    category VARCHAR(20) NOT NULL CHECK (category IN ('*', '**', '***', '****', '*****')),
    notes TEXT,
    INDEX idx_name (name)
    );

-- Связующая таблица отель-гости
CREATE TABLE IF NOT EXISTS hotel_guests (
                                            hotel_id BIGINT NOT NULL,
                                            guest_id BIGINT NOT NULL,
                                            PRIMARY KEY (hotel_id, guest_id),
    FOREIGN KEY (hotel_id) REFERENCES hotels(id) ON DELETE CASCADE,
    FOREIGN KEY (guest_id) REFERENCES guests(id) ON DELETE CASCADE,
    INDEX idx_hotel (hotel_id),
    INDEX idx_guest (guest_id)
    );


-- Тестовые данные
INSERT INTO guests (last_name, first_name, middle_name) VALUES
                                                            ('Иванов', 'Иван', 'Иванович'),
                                                            ('Петрова', 'Мария', 'Сергеевна')
    ('Сидоров', 'Семен', 'Семенович'),
('Кваша', 'Маша', 'Александровна');

INSERT INTO hotels (name, category, notes) VALUES
                                               ('Престиж', '*****', 'Элитный отель в центре'),
                                               ('Уют', '***', 'Небольшой семейный отель'),
                                               ('Казбек', '****', 'Хороший отель в горах'),
                                               ('Мона', '**', 'Дешевый отель на трассе');

INSERT into hotel_guests(hotel_id, guest_id) values
                                                 (1, 1),
                                                 (1, 2),
                                                 (1, 4),
                                                 (2, 1),
                                                 (2, 2),
                                                 (2, 3),
                                                 (2, 4),
                                                 (3, 3),
                                                 (4, 1);

select * from guests;
select * from hotels;
select * from hotel_guests;

