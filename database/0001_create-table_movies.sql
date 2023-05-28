create table
  `movies` (
    `id` int unsigned not null auto_increment primary key,
    `title` varchar(255) not null,
    `writer` varchar(100) not null,
    `cast` varchar(255) not null,
    `release_year` INT null,
    `rating` FLOAT null
  )`;
