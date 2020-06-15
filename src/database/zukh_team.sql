-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Июн 15 2020 г., 15:36
-- Версия сервера: 10.3.22-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `zukh_team`
--

-- --------------------------------------------------------

--
-- Структура таблицы `applications`
--

CREATE TABLE `applications` (
  `application_id` int(15) NOT NULL,
  `auditorium` varchar(8) NOT NULL,
  `device` varchar(20) NOT NULL,
  `comment` text NOT NULL,
  `date` date NOT NULL,
  `status` varchar(3) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tec_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `applications`
--

INSERT INTO `applications` (`application_id`, `auditorium`, `device`, `comment`, `date`, `status`, `user_id`, `tec_id`) VALUES
(1, '203-5', 'Мышка', 'Перестала работать мышка на 4м компьютере', '2020-06-02', '1', 2, 1),
(2, '3-305', 'Проектор', 'Перестал работать проектор, не могу показывать ребятам наши проекты', '2020-06-01', '0', 2, 2),
(3, '203-5', 'утюг', 'не греет вообще и не брызгает вода', '2020-06-09', '2', 2, 1),
(4, '3-203', 'Фильтр', 'Удлиннительный фильтр начал замыкать', '2020-06-06', '1', 1, 1),
(5, '230-1', 'холодильник', 'морозильник перестал греть еду на столе', '2020-05-02', '0', 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `technics`
--

CREATE TABLE `technics` (
  `tec_id` int(11) NOT NULL,
  `tec_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `technics`
--

INSERT INTO `technics` (`tec_id`, `tec_name`) VALUES
(1, 'Какой-то мужик с улицы'),
(2, 'Джеки Чан');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `profession` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `profession`) VALUES
(1, 'Ашрапов Азат Халилович', 'Профессор'),
(2, 'Бахарева Ольга Владимировна', 'Директор института');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`application_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `tec_id` (`tec_id`);

--
-- Индексы таблицы `technics`
--
ALTER TABLE `technics`
  ADD PRIMARY KEY (`tec_id`),
  ADD KEY `tec_id` (`tec_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `applications`
--
ALTER TABLE `applications`
  MODIFY `application_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `technics`
--
ALTER TABLE `technics`
  MODIFY `tec_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `applications_ibfk_2` FOREIGN KEY (`tec_id`) REFERENCES `technics` (`tec_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
