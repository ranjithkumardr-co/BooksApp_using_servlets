
create database ranjith;
use ranjith;

Create table users(
userid int primary Key auto_increment,
Username Varchar(100),
Email varchar(100),
password varchar(100)
);

create table Books
(
userid int references  userid(users),
Bookid int primary Key,
Bookurl varchar(300),
BookName varchar(100),
category varchar(100),
AuthorName varchar(100)
);



create table Readlater
(
Bookid int primary Key,
Bookurl varchar(300),
BookName varchar(100),
category varchar(100),
AuthorName varchar(100)
);

create table Likedbooks
(
Bookid int primary Key,
Bookurl varchar(300),
BookName varchar(100),
category varchar(100),
AuthorName varchar(100)
);


insert into books values(1,101,"https://m.media-amazon.com/images/I/71RZBszBLkS._AC_UY327_FMwebp_QL65_.jpg","Being Earnest","Economics","Oscarwilde");
insert into books values(1,102,"https://m.media-amazon.com/images/I/915O0k5GiyS._AC_UY327_FMwebp_QL65_.jpg","The Odyssey","Economics","Homer");
insert into books values(2,103,"https://m.media-amazon.com/images/I/51P6JiajifL._BG0,0,0,0_FMpng_AC_SY160_SX160_.jpg","No Man's Land","Economics","Niles Krish");
insert into books values(2,104,"https://m.media-amazon.com/images/I/71rywJTxKGS._AC_UY327_FMwebp_QL65_.jpg","Memory","Personal Development","Atkinson");
insert into books values(3,105,"https://m.media-amazon.com/images/I/81tEgsxpNZS._AC_UY327_FMwebp_QL65_.jpg","As a Man Thinketh","History","James Allen");
insert into books values(3,106,"https://m.media-amazon.com/images/I/81zz6LqCreS._AC_UY218_.jpg","How to Stop Worrying","Personal Development","Dale Carnegie");
insert into books values(4,107,"https://m.media-amazon.com/images/I/81VzzF8E0wS._AC_UY218_.jpg","The Wind In The Willows","Sociology","Kenneth");
insert into books values(4,108,"https://m.media-amazon.com/images/I/51upLMyWNvS._AC_UY327_QL65_.jpg","How to Win Friends","Sociology","Dale Carnegie");
insert into books values(5,109,"https://m.media-amazon.com/images/I/81fMeoGo1GS._AC_UY327_QL65_.jpg","My Inventions","Autobiograpy","Nikola Tesla");
insert into books values(5,110,"https://images-eu.ssl-images-amazon.com/images/I/71KaUJQT+9S._AC_UL160_SR160,160_.jpg","1984","Autobiograpy","George orwell");
insert into books values(6,111,"https://images-eu.ssl-images-amazon.com/images/I/81pAe939cfS._AC_UL160_SR160,160_.jpg","Meditations","Autobiograpy","Marcus Aurelius");
insert into books values(6,112,"https://images-na.ssl-images-amazon.com/images/I/716sj4zWPQS.jpg","The Politics","philosophy","Aristotle");
insert into books values(7,113,"https://m.media-amazon.com/images/I/71WI1r5j6HS._AC_UY327_FMwebp_QL65_.jpg","Animal Farm","Business","George Orwell");
insert into books values(7,114,"https://m.media-amazon.com/images/I/81CZkbmSQ7S._AC_UY327_FMwebp_QL65_.jpg","War and Peace","History","Leo Tolstoy");
insert into books values(8,115,"https://m.media-amazon.com/images/I/71wvkyvO0uS._AC_UY327_FMwebp_QL65_.jpg","The Merchant Of venice","History","William Shakesphere");
insert into books values(8,116,"https://images-eu.ssl-images-amazon.com/images/I/81cd2YOY6iS._AC_UL320_SR320,320_.jpg","Nationalism","History","Rabindranath");
insert into books values(9,117,"https://images-eu.ssl-images-amazon.com/images/I/91h14raE85S._AC_UL320_SR320,320_.jpg","Metamorphosis","Science","Franz Kaftha");
insert into books values(9,118,"https://images-eu.ssl-images-amazon.com/images/I/71IczgyUroS._AC_UL320_SR320,320_.jpg","Poetics","History","Aristotle");
insert into books values(10,119,"https://m.media-amazon.com/images/I/81WF2uHd-iS._AC_UY327_FMwebp_QL65_.jpg","Pride and Prejudice","Science","Jane Austen");
insert into books values(10,120,"https://images-eu.ssl-images-amazon.com/images/I/81i6kfH-w+S._AC_UL320_SR320,320_.jpg","The Republic","History","plato");










select * from books;
select * from users;
select * from likedbooks;





