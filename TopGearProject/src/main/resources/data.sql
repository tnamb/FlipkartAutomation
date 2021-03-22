CREATE TABLE cars (
  id INT(5)  PRIMARY KEY,
  brand VARCHAR(15) NOT NULL,
  model VARCHAR(15) NOT NULL,
  year int(5) NOT NULL,
  distance int(10) NOT NULL,
  price int(10) NOT NULL,
  fuel VARCHAR(15) DEFAULT NULL,
  sno int(3) NOT NULL
);

INSERT INTO cars VALUES
  ('1', 'Hyundai' , 'i10', '2019', '10000', '300000','Petrol','1'),
  ('2','Hyundai' , 'i20', '2018', '20000', '200000','Diesel','2'),
  ('3','Hyundai' , 'Verna', '2019', '15000', '250000','Petrol','3'),
  ('4','Tata' , 'Bolt', '2019', '15000', '250000','Petrol','4'),
  ('5','Maruti Suzuki' , 'Ciaz', '2019', '6000000', '200000','Petrol','5'),
  ('6','Honda' , 'Jazz', '2018', '20000', '200000','Diesel','6'),
  ('7','Honda' , 'City', '2019', '15000', '400000','','7'),
  ('8','Maruti Suzuki' , 'Ertiga', '2018', '550000', '200000','Petrol','8'),
  ('9','Tata' , 'Nexon', '2019', '5000', '6000000','Petrol','9');
  