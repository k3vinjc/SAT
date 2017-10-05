/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author kevinj
 */
public class Pruebas {
    public static void main(String args[]){
        crearDeclaracion();
    }
    
    private static void hacerMinusculas(){
        String v="insert into linea(marca,nombre,factor) values (1,'500C',143.56);\n" +
"insert into linea(marca,nombre,factor) values (1,'500',113.58);\n" +
"insert into linea(marca,nombre,factor) values (1,'124 Spider',298.01);\n" +
"insert into linea(marca,nombre,factor) values (2,'Giulietta',151.22);\n" +
"insert into linea(marca,nombre,factor) values (2,'MiTo',132.44);\n" +
"insert into linea(marca,nombre,factor) values (2,'4C',233.42);\n" +
"insert into linea(marca,nombre,factor) values (2,'Giulia',233.48);\n" +
"insert into linea(marca,nombre,factor) values (2,'Stelvio',158.50);\n" +
"insert into linea(marca,nombre,factor) values (3,'4C',156.07);\n" +
"insert into linea(marca,nombre,factor) values (4,'DB9',136.43);\n" +
"insert into linea(marca,nombre,factor) values (4,'Vantage V8',286.24);\n" +
"insert into linea(marca,nombre,factor) values (4,'Vanquish',123.63);\n" +
"insert into linea(marca,nombre,factor) values (4,'Vantage V12',149.58);\n" +
"insert into linea(marca,nombre,factor) values (4,'Rapide',158.15);\n" +
"insert into linea(marca,nombre,factor) values (5,'A4',299.95);\n" +
"insert into linea(marca,nombre,factor) values (5,'A8',133.73);\n" +
"insert into linea(marca,nombre,factor) values (5,'A3',225.89);\n" +
"insert into linea(marca,nombre,factor) values (5,'TT',182.26);\n" +
"insert into linea(marca,nombre,factor) values (5,'A5',232.29);\n" +
"insert into linea(marca,nombre,factor) values (5,'A4 Allroad Quattro',250.59);\n" +
"insert into linea(marca,nombre,factor) values (5,'A6',138.37);\n" +
"insert into linea(marca,nombre,factor) values (5,'A7',183.82);\n" +
"insert into linea(marca,nombre,factor) values (5,'Q3',145.47);\n" +
"insert into linea(marca,nombre,factor) values (5,'Q5',227.90);\n" +
"insert into linea(marca,nombre,factor) values (5,'S5',196.26);\n" +
"insert into linea(marca,nombre,factor) values (5,'A1',295.94);\n" +
"insert into linea(marca,nombre,factor) values (5,'A6 Allroad Quattro',217.82);\n" +
"insert into linea(marca,nombre,factor) values (5,'S7',200.45);\n" +
"insert into linea(marca,nombre,factor) values (5,'S6',123.00);\n" +
"insert into linea(marca,nombre,factor) values (5,'S8',225.60);\n" +
"insert into linea(marca,nombre,factor) values (5,'RS4',164.96);\n" +
"insert into linea(marca,nombre,factor) values (5,'RS5',126.22);\n" +
"insert into linea(marca,nombre,factor) values (5,'R8',189.42);\n" +
"insert into linea(marca,nombre,factor) values (5,'SQ5',112.71);\n" +
"insert into linea(marca,nombre,factor) values (5,'Q7',116.04);\n" +
"insert into linea(marca,nombre,factor) values (5,'RS6',271.13);\n" +
"insert into linea(marca,nombre,factor) values (5,'RS7',276.21);\n" +
"insert into linea(marca,nombre,factor) values (5,'RS Q3',125.67);\n" +
"insert into linea(marca,nombre,factor) values (5,'S3',229.16);\n" +
"insert into linea(marca,nombre,factor) values (5,'S1',166.28);\n" +
"insert into linea(marca,nombre,factor) values (5,'TTS',124.75);\n" +
"insert into linea(marca,nombre,factor) values (5,'S4',217.57);\n" +
"insert into linea(marca,nombre,factor) values (5,'RS3',149.74);\n" +
"insert into linea(marca,nombre,factor) values (5,'SQ7',238.80);\n" +
"insert into linea(marca,nombre,factor) values (5,'Q2',120.16);\n" +
"insert into linea(marca,nombre,factor) values (5,'TTS',128.96);\n" +
"insert into linea(marca,nombre,factor) values (5,'SQ7',216.56);\n" +
"insert into linea(marca,nombre,factor) values (5,'S4',119.94);\n" +
"insert into linea(marca,nombre,factor) values (5,'S6',117.42);\n" +
"insert into linea(marca,nombre,factor) values (5,'S7',116.39);\n" +
"insert into linea(marca,nombre,factor) values (6,'Continental GT',102.63);\n" +
"insert into linea(marca,nombre,factor) values (6,'Mulsanne',267.80);\n" +
"insert into linea(marca,nombre,factor) values (6,'Flying Spur',269.16);\n" +
"insert into linea(marca,nombre,factor) values (6,'Continental GTC',210.14);\n" +
"insert into linea(marca,nombre,factor) values (6,'Bentayga',141.12);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 3',207.26);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 5',142.67);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 4',260.46);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 7',131.77);\n" +
"insert into linea(marca,nombre,factor) values (7,'Z4',185.75);\n" +
"insert into linea(marca,nombre,factor) values (7,'X5',224.36);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 1',218.40);\n" +
"insert into linea(marca,nombre,factor) values (7,'X3',148.78);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 6',171.28);\n" +
"insert into linea(marca,nombre,factor) values (7,'X1',201.01);\n" +
"insert into linea(marca,nombre,factor) values (7,'X6',215.56);\n" +
"insert into linea(marca,nombre,factor) values (7,'I3',178.70);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 2',277.76);\n" +
"insert into linea(marca,nombre,factor) values (7,'X4',180.67);\n" +
"insert into linea(marca,nombre,factor) values (7,'I8',256.35);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 2 Gran Tourer',105.11);\n" +
"insert into linea(marca,nombre,factor) values (7,'Serie 2 Active Tourer',292.67);\n" +
"insert into linea(marca,nombre,factor) values (8,'E6',269.38);\n" +
"insert into linea(marca,nombre,factor) values (9,'Cruze',117.29);\n" +
"insert into linea(marca,nombre,factor) values (9,'Aveo',226.82);\n" +
"insert into linea(marca,nombre,factor) values (9,'Trax',203.69);\n" +
"insert into linea(marca,nombre,factor) values (9,'Orlando',256.00);\n" +
"insert into linea(marca,nombre,factor) values (9,'Spark',159.48);\n" +
"insert into linea(marca,nombre,factor) values (9,'Camaro',146.95);\n" +
"insert into linea(marca,nombre,factor) values (10,'C4',273.02);\n" +
"insert into linea(marca,nombre,factor) values (10,'C3',173.46);\n" +
"insert into linea(marca,nombre,factor) values (10,'C5',203.80);\n" +
"insert into linea(marca,nombre,factor) values (10,'C3 Picasso',102.93);\n" +
"insert into linea(marca,nombre,factor) values (10,'C4 Picasso',292.29);\n" +
"insert into linea(marca,nombre,factor) values (10,'Grand C4 Picasso',202.92);\n" +
"insert into linea(marca,nombre,factor) values (10,'C4 Aircross',192.59);\n" +
"insert into linea(marca,nombre,factor) values (10,'Nemo',220.60);\n" +
"insert into linea(marca,nombre,factor) values (10,'Berlingo',165.81);\n" +
"insert into linea(marca,nombre,factor) values (10,'C-Elysée',166.31);\n" +
"insert into linea(marca,nombre,factor) values (10,'C4 Cactus',267.46);\n" +
"insert into linea(marca,nombre,factor) values (10,'C1',170.32);\n" +
"insert into linea(marca,nombre,factor) values (10,'C-Zero',116.17);\n" +
"insert into linea(marca,nombre,factor) values (10,'C-Elysée',113.04);\n" +
"insert into linea(marca,nombre,factor) values (10,'Spacetourer',129.53);\n" +
"insert into linea(marca,nombre,factor) values (10,'E-Mehari',279.31);\n" +
"insert into linea(marca,nombre,factor) values (10,'C3 Aircross',183.91);\n" +
"insert into linea(marca,nombre,factor) values (11,'Logan',248.46);\n" +
"insert into linea(marca,nombre,factor) values (11,'Lodgy',116.83);\n" +
"insert into linea(marca,nombre,factor) values (11,'Sandero',111.20);\n" +
"insert into linea(marca,nombre,factor) values (11,'Duster',101.52);\n" +
"insert into linea(marca,nombre,factor) values (11,'Dokker',274.15);\n" +
"insert into linea(marca,nombre,factor) values (12,'Serie V',132.76);\n" +
"insert into linea(marca,nombre,factor) values (12,'Serie K',262.60);\n" +
"insert into linea(marca,nombre,factor) values (13,'DS 4',262.42);\n" +
"insert into linea(marca,nombre,factor) values (13,'DS 5',114.65);\n" +
"insert into linea(marca,nombre,factor) values (13,'DS 3',190.39);\n" +
"insert into linea(marca,nombre,factor) values (13,'DS 4 Crossback',246.13);\n" +
"insert into linea(marca,nombre,factor) values (13,'DS 7 Crossback',176.40);\n" +
"insert into linea(marca,nombre,factor) values (14,'488',190.27);\n" +
"insert into linea(marca,nombre,factor) values (14,'GTC4',299.08);\n" +
"insert into linea(marca,nombre,factor) values (14,'California',230.17);\n" +
"insert into linea(marca,nombre,factor) values (14,'F12',105.98);\n" +
"insert into linea(marca,nombre,factor) values (15,'458',262.31);\n" +
"insert into linea(marca,nombre,factor) values (15,'FF',113.33);\n" +
"insert into linea(marca,nombre,factor) values (15,'F12',288.10);\n" +
"insert into linea(marca,nombre,factor) values (15,'California',111.68);\n" +
"insert into linea(marca,nombre,factor) values (15,'488',224.93);\n" +
"insert into linea(marca,nombre,factor) values (16,'Freemont',187.88);\n" +
"insert into linea(marca,nombre,factor) values (16,'Doblò',273.01);\n" +
"insert into linea(marca,nombre,factor) values (16,'Punto',299.24);\n" +
"insert into linea(marca,nombre,factor) values (16,'Panda',247.01);\n" +
"insert into linea(marca,nombre,factor) values (16,'500',238.96);\n" +
"insert into linea(marca,nombre,factor) values (16,'500L',278.80);\n" +
"insert into linea(marca,nombre,factor) values (16,'500L',258.33);\n" +
"insert into linea(marca,nombre,factor) values (16,'500X',177.55);\n" +
"insert into linea(marca,nombre,factor) values (16,'Qubo',298.49);\n" +
"insert into linea(marca,nombre,factor) values (16,'Fiorino',274.36);\n" +
"insert into linea(marca,nombre,factor) values (16,'Bravo',109.49);\n" +
"insert into linea(marca,nombre,factor) values (16,'Doblò',119.98);\n" +
"insert into linea(marca,nombre,factor) values (16,'Doblò',266.00);\n" +
"insert into linea(marca,nombre,factor) values (16,'500C',104.96);\n" +
"insert into linea(marca,nombre,factor) values (16,'Tipo',235.12);\n" +
"insert into linea(marca,nombre,factor) values (16,'124 Spider',153.38);\n" +
"insert into linea(marca,nombre,factor) values (17,'Bravo',112.80);\n" +
"insert into linea(marca,nombre,factor) values (17,'Fiorino',243.25);\n" +
"insert into linea(marca,nombre,factor) values (18,'C-Max',260.35);\n" +
"insert into linea(marca,nombre,factor) values (18,'Fiesta',132.90);\n" +
"insert into linea(marca,nombre,factor) values (18,'Focus',273.20);\n" +
"insert into linea(marca,nombre,factor) values (18,'Mondeo',242.21);\n" +
"insert into linea(marca,nombre,factor) values (18,'Ka',170.55);\n" +
"insert into linea(marca,nombre,factor) values (18,'S-MAX',136.93);\n" +
"insert into linea(marca,nombre,factor) values (18,'B-MAX',169.78);\n" +
"insert into linea(marca,nombre,factor) values (18,'Grand C-Max',193.14);\n" +
"insert into linea(marca,nombre,factor) values (18,'Tourneo Custom',205.46);\n" +
"insert into linea(marca,nombre,factor) values (18,'Kuga',245.09);\n" +
"insert into linea(marca,nombre,factor) values (18,'Galaxy',162.78);\n" +
"insert into linea(marca,nombre,factor) values (18,'Grand Tourneo Connect',224.22);\n" +
"insert into linea(marca,nombre,factor) values (18,'Tourneo Connect',152.94);\n" +
"insert into linea(marca,nombre,factor) values (18,'EcoSport',129.20);\n" +
"insert into linea(marca,nombre,factor) values (18,'Tourneo Courier',288.11);\n" +
"insert into linea(marca,nombre,factor) values (18,'Mustang',188.44);\n" +
"insert into linea(marca,nombre,factor) values (18,'Transit Connect',281.00);\n" +
"insert into linea(marca,nombre,factor) values (18,'Edge',218.22);\n" +
"insert into linea(marca,nombre,factor) values (18,'Ka+',153.99);\n" +
"insert into linea(marca,nombre,factor) values (19,'Accord',184.72);\n" +
"insert into linea(marca,nombre,factor) values (19,'Jazz',192.65);\n" +
"insert into linea(marca,nombre,factor) values (19,'Civic',158.71);\n" +
"insert into linea(marca,nombre,factor) values (19,'CR-V',103.53);\n" +
"insert into linea(marca,nombre,factor) values (19,'HR-V',231.52);\n" +
"insert into linea(marca,nombre,factor) values (20,'I20',165.97);\n" +
"insert into linea(marca,nombre,factor) values (20,'Ix35',133.81);\n" +
"insert into linea(marca,nombre,factor) values (20,'Ix20',218.22);\n" +
"insert into linea(marca,nombre,factor) values (20,'I10',270.17);\n" +
"insert into linea(marca,nombre,factor) values (20,'Santa Fe',250.22);\n" +
"insert into linea(marca,nombre,factor) values (20,'Veloster',126.69);\n" +
"insert into linea(marca,nombre,factor) values (20,'I40',137.12);\n" +
"insert into linea(marca,nombre,factor) values (20,'Elantra',112.85);\n" +
"insert into linea(marca,nombre,factor) values (20,'I30',129.24);\n" +
"insert into linea(marca,nombre,factor) values (20,'Grand Santa Fe',218.54);\n" +
"insert into linea(marca,nombre,factor) values (20,'Genesis',197.08);\n" +
"insert into linea(marca,nombre,factor) values (20,'H-1 Travel',170.57);\n" +
"insert into linea(marca,nombre,factor) values (20,'Tucson',134.40);\n" +
"insert into linea(marca,nombre,factor) values (20,'I20 Active',296.36);\n" +
"insert into linea(marca,nombre,factor) values (20,'IONIQ',261.03);\n" +
"insert into linea(marca,nombre,factor) values (21,'Q70',196.95);\n" +
"insert into linea(marca,nombre,factor) values (21,'Q50',192.05);\n" +
"insert into linea(marca,nombre,factor) values (21,'QX70',112.64);\n" +
"insert into linea(marca,nombre,factor) values (21,'QX50',194.93);\n" +
"insert into linea(marca,nombre,factor) values (21,'Q60',266.18);\n" +
"insert into linea(marca,nombre,factor) values (21,'Q30',124.02);\n" +
"insert into linea(marca,nombre,factor) values (21,'QX30',286.65);\n" +
"insert into linea(marca,nombre,factor) values (22,'D-Max',278.06);\n" +
"insert into linea(marca,nombre,factor) values (23,'XF',166.81);\n" +
"insert into linea(marca,nombre,factor) values (23,'Serie XK',185.14);\n" +
"insert into linea(marca,nombre,factor) values (23,'F-Type',166.40);\n" +
"insert into linea(marca,nombre,factor) values (23,'XJ',287.10);\n" +
"insert into linea(marca,nombre,factor) values (23,'XE',137.82);\n" +
"insert into linea(marca,nombre,factor) values (23,'F-Pace',217.49);\n" +
"insert into linea(marca,nombre,factor) values (23,'E-Pace',280.38);\n" +
"insert into linea(marca,nombre,factor) values (24,'Grand Cherokee',181.47);\n" +
"insert into linea(marca,nombre,factor) values (24,'Wrangler Unlimited',199.44);\n" +
"insert into linea(marca,nombre,factor) values (24,'Cherokee',129.20);\n" +
"insert into linea(marca,nombre,factor) values (24,'Wrangler',200.12);\n" +
"insert into linea(marca,nombre,factor) values (24,'Renegade',235.34);\n" +
"insert into linea(marca,nombre,factor) values (24,'Compass',238.29);\n" +
"insert into linea(marca,nombre,factor) values (24,'Renegade',163.96);\n" +
"insert into linea(marca,nombre,factor) values (25,'Wrangler Unlimited',207.16);\n" +
"insert into linea(marca,nombre,factor) values (25,'Wrangler',111.40);\n" +
"insert into linea(marca,nombre,factor) values (25,'Cherokee',295.10);\n" +
"insert into linea(marca,nombre,factor) values (26,'Picanto',217.67);\n" +
"insert into linea(marca,nombre,factor) values (26,'Rio',212.44);\n" +
"insert into linea(marca,nombre,factor) values (26,'Sportage',151.88);\n" +
"insert into linea(marca,nombre,factor) values (26,'Venga',172.68);\n" +
"insert into linea(marca,nombre,factor) values (26,'Optima',279.95);\n" +
"insert into linea(marca,nombre,factor) values (26,'Cee\\'d',111.06);\n" +
"insert into linea(marca,nombre,factor) values (26,'Cee\\'d Sportswagon',274.41);\n" +
"insert into linea(marca,nombre,factor) values (26,'Carens',133.11);\n" +
"insert into linea(marca,nombre,factor) values (26,'Pro_cee\\'d',130.67);\n" +
"insert into linea(marca,nombre,factor) values (26,'Sorento',172.44);\n" +
"insert into linea(marca,nombre,factor) values (26,'Soul',103.46);\n" +
"insert into linea(marca,nombre,factor) values (26,'Niro',285.19);\n" +
"insert into linea(marca,nombre,factor) values (26,'Soul EV',105.44);\n" +
"insert into linea(marca,nombre,factor) values (26,'Pro_cee\\'d GT',163.32);\n" +
"insert into linea(marca,nombre,factor) values (27,'4X4',142.37);\n" +
"insert into linea(marca,nombre,factor) values (27,'Priora',276.60);\n" +
"insert into linea(marca,nombre,factor) values (28,'Aventador',259.22);\n" +
"insert into linea(marca,nombre,factor) values (28,'Huracán',280.46);\n" +
"insert into linea(marca,nombre,factor) values (29,'Ypsilon',296.81);\n" +
"insert into linea(marca,nombre,factor) values (29,'Voyager',100.12);\n" +
"insert into linea(marca,nombre,factor) values (29,'Delta',203.25);\n" +
"insert into linea(marca,nombre,factor) values (30,'Thema',230.13);\n" +
"insert into linea(marca,nombre,factor) values (30,'Delta',297.33);\n" +
"insert into linea(marca,nombre,factor) values (31,'Defender',199.09);\n" +
"insert into linea(marca,nombre,factor) values (31,'Discovery 4',268.27);\n" +
"insert into linea(marca,nombre,factor) values (31,'Range Rover',132.94);\n" +
"insert into linea(marca,nombre,factor) values (31,'Range Rover Evoque',136.89);\n" +
"insert into linea(marca,nombre,factor) values (31,'Freelander',214.64);\n" +
"insert into linea(marca,nombre,factor) values (31,'Range Rover Sport',255.62);\n" +
"insert into linea(marca,nombre,factor) values (31,'Discovery Sport',155.80);\n" +
"insert into linea(marca,nombre,factor) values (31,'Discovery',138.56);\n" +
"insert into linea(marca,nombre,factor) values (31,'Range Rover Velar',255.46);\n" +
"insert into linea(marca,nombre,factor) values (32,'GS',277.85);\n" +
"insert into linea(marca,nombre,factor) values (32,'RX',276.38);\n" +
"insert into linea(marca,nombre,factor) values (32,'CT',299.42);\n" +
"insert into linea(marca,nombre,factor) values (32,'IS',291.07);\n" +
"insert into linea(marca,nombre,factor) values (32,'NX',262.01);\n" +
"insert into linea(marca,nombre,factor) values (32,'RC',171.31);\n" +
"insert into linea(marca,nombre,factor) values (32,'LS',118.35);\n" +
"insert into linea(marca,nombre,factor) values (32,'LC',169.89);\n" +
"insert into linea(marca,nombre,factor) values (33,'XUV500',190.93);\n" +
"insert into linea(marca,nombre,factor) values (34,'GranCabrio',285.55);\n" +
"insert into linea(marca,nombre,factor) values (34,'Quattroporte',208.96);\n" +
"insert into linea(marca,nombre,factor) values (34,'Ghibli',246.28);\n" +
"insert into linea(marca,nombre,factor) values (34,'GranTurismo',291.89);\n" +
"insert into linea(marca,nombre,factor) values (34,'Levante',288.46);\n" +
"insert into linea(marca,nombre,factor) values (35,'Mazda2',222.79);\n" +
"insert into linea(marca,nombre,factor) values (35,'CX-5',263.65);\n" +
"insert into linea(marca,nombre,factor) values (35,'Mazda6',147.09);\n" +
"insert into linea(marca,nombre,factor) values (35,'MX-5',151.14);\n" +
"insert into linea(marca,nombre,factor) values (35,'Mazda3',164.09);\n" +
"insert into linea(marca,nombre,factor) values (35,'Mazda5',185.89);\n" +
"insert into linea(marca,nombre,factor) values (35,'CX-9',296.44);\n" +
"insert into linea(marca,nombre,factor) values (35,'CX-3',189.84);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase SL',264.12);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase SLK',295.11);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase V',130.86);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase C',212.07);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase M',201.02);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase G',280.88);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase E',133.18);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase CL',174.68);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase S',200.98);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLK',234.88);\n" +
"insert into linea(marca,nombre,factor) values (36,'SLS AMG',213.51);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase B',117.44);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase A',236.96);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GL',234.32);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase CLS',207.34);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase CLA',170.80);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLA',152.87);\n" +
"insert into linea(marca,nombre,factor) values (36,'AMG GT',148.59);\n" +
"insert into linea(marca,nombre,factor) values (36,'Vito',157.42);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLE Coupé',153.46);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLE',284.89);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLE Coupé',235.90);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLK',183.81);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLC',272.76);\n" +
"insert into linea(marca,nombre,factor) values (36,'Citan',225.38);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase GLS',209.98);\n" +
"insert into linea(marca,nombre,factor) values (36,'Clase SLC',161.80);\n" +
"insert into linea(marca,nombre,factor) values (36,'GLC Coupé',120.44);\n" +
"insert into linea(marca,nombre,factor) values (36,'Mercedes-AMG GT',180.88);\n" +
"insert into linea(marca,nombre,factor) values (37,'MINI',151.78);\n" +
"insert into linea(marca,nombre,factor) values (37,'COUNTRYMAN',273.83);\n" +
"insert into linea(marca,nombre,factor) values (37,'PACEMAN',116.44);\n" +
"insert into linea(marca,nombre,factor) values (37,'CLUBMAN',112.56);\n" +
"insert into linea(marca,nombre,factor) values (38,'Montero',117.01);\n" +
"insert into linea(marca,nombre,factor) values (38,'I-MiEV',178.60);\n" +
"insert into linea(marca,nombre,factor) values (38,'ASX',194.95);\n" +
"insert into linea(marca,nombre,factor) values (38,'Outlander',115.50);\n" +
"insert into linea(marca,nombre,factor) values (38,'Space Star',147.60);\n" +
"insert into linea(marca,nombre,factor) values (38,'L200',249.99);\n" +
"insert into linea(marca,nombre,factor) values (39,'Roadster',250.12);\n" +
"insert into linea(marca,nombre,factor) values (39,'Plus 8',292.74);\n" +
"insert into linea(marca,nombre,factor) values (39,'Plus 4',233.63);\n" +
"insert into linea(marca,nombre,factor) values (39,'4/4',277.71);\n" +
"insert into linea(marca,nombre,factor) values (40,'X-TRAIL',262.39);\n" +
"insert into linea(marca,nombre,factor) values (40,'QASHQAI',110.69);\n" +
"insert into linea(marca,nombre,factor) values (40,'NOTE',192.13);\n" +
"insert into linea(marca,nombre,factor) values (40,'LEAF',193.72);\n" +
"insert into linea(marca,nombre,factor) values (40,'Pathfinder',112.33);\n" +
"insert into linea(marca,nombre,factor) values (40,'EVALIA',284.30);\n" +
"insert into linea(marca,nombre,factor) values (40,'Navara',229.81);\n" +
"insert into linea(marca,nombre,factor) values (40,'Micra',190.16);\n" +
"insert into linea(marca,nombre,factor) values (40,'JUKE',255.08);\n" +
"insert into linea(marca,nombre,factor) values (40,'370Z',233.59);\n" +
"insert into linea(marca,nombre,factor) values (40,'NV200',139.41);\n" +
"insert into linea(marca,nombre,factor) values (40,'GT-R',229.04);\n" +
"insert into linea(marca,nombre,factor) values (40,'PULSAR',276.48);\n" +
"insert into linea(marca,nombre,factor) values (40,'Murano',277.79);\n" +
"insert into linea(marca,nombre,factor) values (40,'NV200 EVALIA',242.56);\n" +
"insert into linea(marca,nombre,factor) values (40,'E-NV200 EVALIA',208.41);\n" +
"insert into linea(marca,nombre,factor) values (41,'Corsa',281.06);\n" +
"insert into linea(marca,nombre,factor) values (41,'Astra',188.50);\n" +
"insert into linea(marca,nombre,factor) values (41,'Meriva',136.80);\n" +
"insert into linea(marca,nombre,factor) values (41,'Zafira Tourer',146.51);\n" +
"insert into linea(marca,nombre,factor) values (41,'Zafira',272.52);\n" +
"insert into linea(marca,nombre,factor) values (41,'Insignia',110.78);\n" +
"insert into linea(marca,nombre,factor) values (41,'Combo',230.56);\n" +
"insert into linea(marca,nombre,factor) values (41,'Ampera',272.45);\n" +
"insert into linea(marca,nombre,factor) values (41,'Mokka',178.66);\n" +
"insert into linea(marca,nombre,factor) values (41,'Adam',178.70);\n" +
"insert into linea(marca,nombre,factor) values (41,'Cabrio',156.83);\n" +
"insert into linea(marca,nombre,factor) values (41,'Antara',271.26);\n" +
"insert into linea(marca,nombre,factor) values (41,'Karl',145.86);\n" +
"insert into linea(marca,nombre,factor) values (41,'GTC',201.82);\n" +
"insert into linea(marca,nombre,factor) values (41,'GTC',245.07);\n" +
"insert into linea(marca,nombre,factor) values (41,'Mokka',120.73);\n" +
"insert into linea(marca,nombre,factor) values (41,'Zafira',182.18);\n" +
"insert into linea(marca,nombre,factor) values (41,'Crossland X',179.21);\n" +
"insert into linea(marca,nombre,factor) values (41,'Mokka X',100.34);\n" +
"insert into linea(marca,nombre,factor) values (42,'308',179.08);\n" +
"insert into linea(marca,nombre,factor) values (42,'807',163.47);\n" +
"insert into linea(marca,nombre,factor) values (42,'Bipper',110.00);\n" +
"insert into linea(marca,nombre,factor) values (42,'508',189.76);\n" +
"insert into linea(marca,nombre,factor) values (42,'Partner',234.86);\n" +
"insert into linea(marca,nombre,factor) values (42,'3008',233.61);\n" +
"insert into linea(marca,nombre,factor) values (42,'208',212.20);\n" +
"insert into linea(marca,nombre,factor) values (42,'2008',168.65);\n" +
"insert into linea(marca,nombre,factor) values (42,'RCZ',114.38);\n" +
"insert into linea(marca,nombre,factor) values (42,'5008',127.60);\n" +
"insert into linea(marca,nombre,factor) values (42,'4008',236.42);\n" +
"insert into linea(marca,nombre,factor) values (42,'108',292.09);\n" +
"insert into linea(marca,nombre,factor) values (42,'207',156.87);\n" +
"insert into linea(marca,nombre,factor) values (42,'Ion',125.75);\n" +
"insert into linea(marca,nombre,factor) values (42,'Traveller',266.17);\n" +
"insert into linea(marca,nombre,factor) values (43,'911',252.38);\n" +
"insert into linea(marca,nombre,factor) values (43,'Boxster',214.01);\n" +
"insert into linea(marca,nombre,factor) values (43,'Cayenne',207.03);\n" +
"insert into linea(marca,nombre,factor) values (43,'Panamera',234.05);\n" +
"insert into linea(marca,nombre,factor) values (43,'918',159.00);\n" +
"insert into linea(marca,nombre,factor) values (43,'Macan',207.98);\n" +
"insert into linea(marca,nombre,factor) values (43,'Cayman',111.75);\n" +
"insert into linea(marca,nombre,factor) values (43,'718',150.56);\n" +
"insert into linea(marca,nombre,factor) values (44,'Fluence',134.61);\n" +
"insert into linea(marca,nombre,factor) values (44,'Grand Scénic',290.77);\n" +
"insert into linea(marca,nombre,factor) values (44,'Latitude',246.19);\n" +
"insert into linea(marca,nombre,factor) values (44,'Clio',142.36);\n" +
"insert into linea(marca,nombre,factor) values (44,'Scénic',139.45);\n" +
"insert into linea(marca,nombre,factor) values (44,'Laguna',287.90);\n" +
"insert into linea(marca,nombre,factor) values (44,'Kangoo Combi',266.26);\n" +
"insert into linea(marca,nombre,factor) values (44,'Mégane',226.98);\n" +
"insert into linea(marca,nombre,factor) values (44,'Grand Kangoo Combi',155.98);\n" +
"insert into linea(marca,nombre,factor) values (44,'Captur',180.59);\n" +
"insert into linea(marca,nombre,factor) values (44,'ZOE',162.21);\n" +
"insert into linea(marca,nombre,factor) values (44,'Koleos',113.10);\n" +
"insert into linea(marca,nombre,factor) values (44,'Twingo',166.54);\n" +
"insert into linea(marca,nombre,factor) values (44,'Espace',283.33);\n" +
"insert into linea(marca,nombre,factor) values (44,'Kadjar',133.44);\n" +
"insert into linea(marca,nombre,factor) values (44,'Talisman',208.69);\n" +
"insert into linea(marca,nombre,factor) values (45,'Phantom',239.46);\n" +
"insert into linea(marca,nombre,factor) values (46,'Ibiza',107.22);\n" +
"insert into linea(marca,nombre,factor) values (46,'Nuevo León',290.04);\n" +
"insert into linea(marca,nombre,factor) values (46,'Alhambra',243.69);\n" +
"insert into linea(marca,nombre,factor) values (46,'Altea',101.80);\n" +
"insert into linea(marca,nombre,factor) values (46,'Mii',264.84);\n" +
"insert into linea(marca,nombre,factor) values (46,'Toledo',246.80);\n" +
"insert into linea(marca,nombre,factor) values (46,'Altea XL',269.48);\n" +
"insert into linea(marca,nombre,factor) values (46,'Ateca',222.40);\n" +
"insert into linea(marca,nombre,factor) values (46,'León',168.42);\n" +
"insert into linea(marca,nombre,factor) values (46,'Nuevo Ibiza',185.92);\n" +
"insert into linea(marca,nombre,factor) values (47,'Octavia',284.54);\n" +
"insert into linea(marca,nombre,factor) values (47,'Fabia',254.35);\n" +
"insert into linea(marca,nombre,factor) values (47,'Roomster',100.81);\n" +
"insert into linea(marca,nombre,factor) values (47,'Yeti',156.20);\n" +
"insert into linea(marca,nombre,factor) values (47,'Superb',153.56);\n" +
"insert into linea(marca,nombre,factor) values (47,'Citigo',293.47);\n" +
"insert into linea(marca,nombre,factor) values (47,'Rapid',297.42);\n" +
"insert into linea(marca,nombre,factor) values (47,'Spaceback',249.17);\n" +
"insert into linea(marca,nombre,factor) values (47,'Scout',236.88);\n" +
"insert into linea(marca,nombre,factor) values (47,'Kodiaq',197.68);\n" +
"insert into linea(marca,nombre,factor) values (48,'Fortwo',167.44);\n" +
"insert into linea(marca,nombre,factor) values (48,'Forfour',247.08);\n" +
"insert into linea(marca,nombre,factor) values (49,'Rexton',227.83);\n" +
"insert into linea(marca,nombre,factor) values (49,'Rodius',182.28);\n" +
"insert into linea(marca,nombre,factor) values (49,'Korando',103.75);\n" +
"insert into linea(marca,nombre,factor) values (49,'Actyon Sports Pick Up',172.62);\n" +
"insert into linea(marca,nombre,factor) values (49,'Tivoli',107.24);\n" +
"insert into linea(marca,nombre,factor) values (49,'XLV',256.45);\n" +
"insert into linea(marca,nombre,factor) values (50,'Forester',283.79);\n" +
"insert into linea(marca,nombre,factor) values (50,'XV',287.12);\n" +
"insert into linea(marca,nombre,factor) values (50,'Outback',267.81);\n" +
"insert into linea(marca,nombre,factor) values (50,'BRZ',199.24);\n" +
"insert into linea(marca,nombre,factor) values (50,'WRX STI',247.11);\n" +
"insert into linea(marca,nombre,factor) values (50,'LEVORG',281.77);\n" +
"insert into linea(marca,nombre,factor) values (50,'WRX STI',135.25);\n" +
"insert into linea(marca,nombre,factor) values (51,'Grand Vitara',286.24);\n" +
"insert into linea(marca,nombre,factor) values (51,'Swift',250.58);\n" +
"insert into linea(marca,nombre,factor) values (51,'SX4',285.39);\n" +
"insert into linea(marca,nombre,factor) values (51,'Jimny',218.84);\n" +
"insert into linea(marca,nombre,factor) values (51,'SX4 S-Cross',273.23);\n" +
"insert into linea(marca,nombre,factor) values (51,'Celerio',248.43);\n" +
"insert into linea(marca,nombre,factor) values (51,'Kizashi',272.81);\n" +
"insert into linea(marca,nombre,factor) values (51,'Vitara',261.02);\n" +
"insert into linea(marca,nombre,factor) values (51,'Baleno',218.75);\n" +
"insert into linea(marca,nombre,factor) values (51,'Ignis',221.87);\n" +
"insert into linea(marca,nombre,factor) values (52,'Xenon',299.32);\n" +
"insert into linea(marca,nombre,factor) values (52,'Aria',223.71);\n" +
"insert into linea(marca,nombre,factor) values (52,'Vista',185.03);\n" +
"insert into linea(marca,nombre,factor) values (53,'Model X',291.83);\n" +
"insert into linea(marca,nombre,factor) values (53,'Model S',109.72);\n" +
"insert into linea(marca,nombre,factor) values (54,'Avensis',248.47);\n" +
"insert into linea(marca,nombre,factor) values (54,'Land Cruiser',295.15);\n" +
"insert into linea(marca,nombre,factor) values (54,'Yaris',188.35);\n" +
"insert into linea(marca,nombre,factor) values (54,'Verso',274.43);\n" +
"insert into linea(marca,nombre,factor) values (54,'Auris',258.39);\n" +
"insert into linea(marca,nombre,factor) values (54,'Prius+',243.78);\n" +
"insert into linea(marca,nombre,factor) values (54,'GT86',221.51);\n" +
"insert into linea(marca,nombre,factor) values (54,'Prius',290.53);\n" +
"insert into linea(marca,nombre,factor) values (54,'Rav4',131.24);\n" +
"insert into linea(marca,nombre,factor) values (54,'Aygo',160.24);\n" +
"insert into linea(marca,nombre,factor) values (54,'Hilux',101.26);\n" +
"insert into linea(marca,nombre,factor) values (54,'Land Cruiser 200',252.21);\n" +
"insert into linea(marca,nombre,factor) values (54,'Proace Verso',167.07);\n" +
"insert into linea(marca,nombre,factor) values (54,'C-HR',104.45);\n" +
"insert into linea(marca,nombre,factor) values (55,'Polo',187.39);\n" +
"insert into linea(marca,nombre,factor) values (55,'Jetta',142.98);\n" +
"insert into linea(marca,nombre,factor) values (55,'Phaeton',297.23);\n" +
"insert into linea(marca,nombre,factor) values (55,'Golf',240.07);\n" +
"insert into linea(marca,nombre,factor) values (55,'Touran',215.78);\n" +
"insert into linea(marca,nombre,factor) values (55,'Touareg',131.06);\n" +
"insert into linea(marca,nombre,factor) values (55,'Beetle',138.00);\n" +
"insert into linea(marca,nombre,factor) values (55,'Sharan',273.80);\n" +
"insert into linea(marca,nombre,factor) values (55,'Tiguan',243.51);\n" +
"insert into linea(marca,nombre,factor) values (55,'Multivan',259.66);\n" +
"insert into linea(marca,nombre,factor) values (55,'California',178.57);\n" +
"insert into linea(marca,nombre,factor) values (55,'Caravelle',275.65);\n" +
"insert into linea(marca,nombre,factor) values (55,'Up!',282.85);\n" +
"insert into linea(marca,nombre,factor) values (55,'CC',215.68);\n" +
"insert into linea(marca,nombre,factor) values (55,'Golf Sportsvan',111.51);\n" +
"insert into linea(marca,nombre,factor) values (55,'Amarok',102.52);\n" +
"insert into linea(marca,nombre,factor) values (55,'Caddy',252.96);\n" +
"insert into linea(marca,nombre,factor) values (55,'Transporter',232.86);\n" +
"insert into linea(marca,nombre,factor) values (55,'Scirocco',163.08);\n" +
"insert into linea(marca,nombre,factor) values (55,'Passat',135.47);\n" +
"insert into linea(marca,nombre,factor) values (55,'Eos',268.23);\n" +
"insert into linea(marca,nombre,factor) values (55,'Arteon',239.92);\n" +
"insert into linea(marca,nombre,factor) values (56,'V70',261.62);\n" +
"insert into linea(marca,nombre,factor) values (56,'S80',111.28);\n" +
"insert into linea(marca,nombre,factor) values (56,'XC70',103.36);\n" +
"insert into linea(marca,nombre,factor) values (56,'V60',299.21);\n" +
"insert into linea(marca,nombre,factor) values (56,'S60',193.89);\n" +
"insert into linea(marca,nombre,factor) values (56,'XC90',279.43);\n" +
"insert into linea(marca,nombre,factor) values (56,'XC60',127.89);\n" +
"insert into linea(marca,nombre,factor) values (56,'V40',198.24);\n" +
"insert into linea(marca,nombre,factor) values (56,'V40 Cross Country',142.71);\n" +
"insert into linea(marca,nombre,factor) values (56,'V60 Cross Country',148.20);\n" +
"insert into linea(marca,nombre,factor) values (56,'S60 Cross Country',286.79);\n" +
"insert into linea(marca,nombre,factor) values (56,'S90',154.28);\n" +
"insert into linea(marca,nombre,factor) values (56,'V90',173.43);\n" +
"insert into linea(marca,nombre,factor) values (56,'V90 Cross Country',296.84);";
        System.out.println(v.toLowerCase());
    }
    
    private static void crearDeclaracion(){
        Declaracion l=new Declaracion("volvo", "v70", 2000, 50, "1999-5-23");
        if(l.cod_declaracion==0)System.out.println(l.getError());
        else System.out.println("Código: "+l.cod_declaracion);
        
    }

    private static void crearManifiesto(){
        Manifiesto m=new Manifiesto("volvo", "v70", 2000, "23-5-1999","Guatemala");
        if(m.cod_manifiesto==0)System.out.println(m.getError());
        else System.out.println("Código: "+m.cod_manifiesto);
        
    }
    
    public static void generar(){
        String marca="",linea="",lexema="";
        int state=0, numMarca=0;
        char letras[]=ml.toCharArray();
        for (int i = 0; i <= letras.length; i++) {
            char c;
            if(i==letras.length){
                c=' ';
                state=1;
            }else{
                c=letras[i];
            }
            switch(state){
                case 0:
                    if(c!='\n'){
                        lexema+=c;
                    }else{
                        state++;
                    }
                    break;
                case 1:
                    if(c!='\n'){
                        linea=lexema.trim();
                        i--;
                        /*System.out.println("insert into linea(marca,nombre,factor) values ("+numMarca+",'"+linea+"',"+
                                (Math.random()*200+100)+")");*/
                        if(i==letras.length-1) i+=2;
                    }else{
                        marca=lexema.trim();numMarca++;
                        System.out.println("insert into marca(nombre) values ('"+marca+"');");
                    }
                    lexema="";
                    state=0;
                
            }
        }
    }
    
        static String ml="ABARTH\n" +
"\n" +
"500C\n" +
"500\n" +
"124 Spider\n" +
"ALFA ROMEO\n" +
"\n" +
"Giulietta\n" +
"MiTo\n" +
"4C\n" +
"Giulia\n" +
"Stelvio\n" +
"ALFA ROMEO (FIAT)\n" +
"\n" +
"4C\n" +
"ASTON MARTIN\n" +
"\n" +
"DB9\n" +
"Vantage V8\n" +
"Vanquish\n" +
"Vantage V12\n" +
"Rapide\n" +
"AUDI\n" +
"\n" +
"A4\n" +
"A8\n" +
"A3\n" +
"TT\n" +
"A5\n" +
"A4 Allroad Quattro\n" +
"A6\n" +
"A7\n" +
"Q3\n" +
"Q5\n" +
"S5\n" +
"A1\n" +
"A6 Allroad Quattro\n" +
"S7\n" +
"S6\n" +
"S8\n" +
"RS4\n" +
"RS5\n" +
"R8\n" +
"SQ5\n" +
"Q7\n" +
"RS6\n" +
"RS7\n" +
"RS Q3\n" +
"S3\n" +
"S1\n" +
"TTS\n" +
"S4\n" +
"RS3\n" +
"SQ7\n" +
"Q2\n" +
"TTS\n" +
"SQ7\n" +
"S4\n" +
"S6\n" +
"S7\n" +
"BENTLEY\n" +
"\n" +
"Continental GT\n" +
"Mulsanne\n" +
"Flying Spur\n" +
"Continental GTC\n" +
"Bentayga\n" +
"BMW\n" +
"\n" +
"Serie 3\n" +
"Serie 5\n" +
"Serie 4\n" +
"Serie 7\n" +
"Z4\n" +
"X5\n" +
"Serie 1\n" +
"X3\n" +
"Serie 6\n" +
"X1\n" +
"X6\n" +
"I3\n" +
"Serie 2\n" +
"X4\n" +
"I8\n" +
"Serie 2 Gran Tourer\n" +
"Serie 2 Active Tourer\n" +
"BYD\n" +
"\n" +
"E6\n" +
"CHEVROLET\n" +
"\n" +
"Cruze\n" +
"Aveo\n" +
"Trax\n" +
"Orlando\n" +
"Spark\n" +
"Camaro\n" +
"CITROEN\n" +
"\n" +
"C4\n" +
"C3\n" +
"C5\n" +
"C3 Picasso\n" +
"C4 Picasso\n" +
"Grand C4 Picasso\n" +
"C4 Aircross\n" +
"Nemo\n" +
"Berlingo\n" +
"C-Elysée\n" +
"C4 Cactus\n" +
"C1\n" +
"C-Zero\n" +
"C-Elysée\n" +
"Spacetourer\n" +
"E-Mehari\n" +
"C3 Aircross\n" +
"DACIA\n" +
"\n" +
"Logan\n" +
"Lodgy\n" +
"Sandero\n" +
"Duster\n" +
"Dokker\n" +
"DFSK\n" +
"\n" +
"Serie V\n" +
"Serie K\n" +
"DS\n" +
"\n" +
"DS 4\n" +
"DS 5\n" +
"DS 3\n" +
"DS 4 Crossback\n" +
"DS 7 Crossback\n" +
"FERRARI\n" +
"\n" +
"488\n" +
"GTC4\n" +
"California\n" +
"F12\n" +
"FERRARI (FCA)\n" +
"\n" +
"458\n" +
"FF\n" +
"F12\n" +
"California\n" +
"488\n" +
"FIAT\n" +
"\n" +
"Freemont\n" +
"Doblò\n" +
"Punto\n" +
"Panda\n" +
"500\n" +
"500L\n" +
"500L\n" +
"500X\n" +
"Qubo\n" +
"Fiorino\n" +
"Bravo\n" +
"Doblò\n" +
"Doblò\n" +
"500C\n" +
"Tipo\n" +
"124 Spider\n" +
"FIAT (FIAT)\n" +
"\n" +
"Bravo\n" +
"Fiorino\n" +
"FORD\n" +
"\n" +
"C-Max\n" +
"Fiesta\n" +
"Focus\n" +
"Mondeo\n" +
"Ka\n" +
"S-MAX\n" +
"B-MAX\n" +
"Grand C-Max\n" +
"Tourneo Custom\n" +
"Kuga\n" +
"Galaxy\n" +
"Grand Tourneo Connect\n" +
"Tourneo Connect\n" +
"EcoSport\n" +
"Tourneo Courier\n" +
"Mustang\n" +
"Transit Connect\n" +
"Edge\n" +
"Ka+\n" +
"HONDA\n" +
"\n" +
"Accord\n" +
"Jazz\n" +
"Civic\n" +
"CR-V\n" +
"HR-V\n" +
"HYUNDAI\n" +
"\n" +
"I20\n" +
"Ix35\n" +
"Ix20\n" +
"I10\n" +
"Santa Fe\n" +
"Veloster\n" +
"I40\n" +
"Elantra\n" +
"I30\n" +
"Grand Santa Fe\n" +
"Genesis\n" +
"H-1 Travel\n" +
"Tucson\n" +
"I20 Active\n" +
"IONIQ\n" +
"INFINITI\n" +
"\n" +
"Q70\n" +
"Q50\n" +
"QX70\n" +
"QX50\n" +
"Q60\n" +
"Q30\n" +
"QX30\n" +
"ISUZU\n" +
"\n" +
"D-Max\n" +
"JAGUAR\n" +
"\n" +
"XF\n" +
"Serie XK\n" +
"F-Type\n" +
"XJ\n" +
"XE\n" +
"F-Pace\n" +
"E-Pace\n" +
"JEEP\n" +
"\n" +
"Grand Cherokee\n" +
"Wrangler Unlimited\n" +
"Cherokee\n" +
"Wrangler\n" +
"Renegade\n" +
"Compass\n" +
"Renegade\n" +
"JEEP (FIAT)\n" +
"\n" +
"Wrangler Unlimited\n" +
"Wrangler\n" +
"Cherokee\n" +
"KIA\n" +
"\n" +
"Picanto\n" +
"Rio\n" +
"Sportage\n" +
"Venga\n" +
"Optima\n" +
"Cee'd\n" +
"Cee'd Sportswagon\n" +
"Carens\n" +
"Pro_cee'd\n" +
"Sorento\n" +
"Soul\n" +
"Niro\n" +
"Soul EV\n" +
"Pro_cee'd GT\n" +
"LADA\n" +
"\n" +
"4X4\n" +
"Priora\n" +
"LAMBORGHINI\n" +
"\n" +
"Aventador\n" +
"Huracán\n" +
"LANCIA\n" +
"\n" +
"Ypsilon\n" +
"Voyager\n" +
"Delta\n" +
"LANCIA (FIAT)\n" +
"\n" +
"Thema\n" +
"Delta\n" +
"LAND ROVER\n" +
"\n" +
"Defender\n" +
"Discovery 4\n" +
"Range Rover\n" +
"Range Rover Evoque\n" +
"Freelander\n" +
"Range Rover Sport\n" +
"Discovery Sport\n" +
"Discovery\n" +
"Range Rover Velar\n" +
"LEXUS\n" +
"\n" +
"GS\n" +
"RX\n" +
"CT\n" +
"IS\n" +
"NX\n" +
"RC\n" +
"LS\n" +
"LC\n" +
"MAHINDRA\n" +
"\n" +
"XUV500\n" +
"MASERATI\n" +
"\n" +
"GranCabrio\n" +
"Quattroporte\n" +
"Ghibli\n" +
"GranTurismo\n" +
"Levante\n" +
"MAZDA\n" +
"\n" +
"Mazda2\n" +
"CX-5\n" +
"Mazda6\n" +
"MX-5\n" +
"Mazda3\n" +
"Mazda5\n" +
"CX-9\n" +
"CX-3\n" +
"MERCEDES\n" +
"\n" +
"Clase SL\n" +
"Clase SLK\n" +
"Clase V\n" +
"Clase C\n" +
"Clase M\n" +
"Clase G\n" +
"Clase E\n" +
"Clase CL\n" +
"Clase S\n" +
"Clase GLK\n" +
"SLS AMG\n" +
"Clase B\n" +
"Clase A\n" +
"Clase GL\n" +
"Clase CLS\n" +
"Clase CLA\n" +
"Clase GLA\n" +
"AMG GT\n" +
"Vito\n" +
"Clase GLE Coupé\n" +
"Clase GLE\n" +
"Clase GLE Coupé\n" +
"Clase GLK\n" +
"Clase GLC\n" +
"Citan\n" +
"Clase GLS\n" +
"Clase SLC\n" +
"GLC Coupé\n" +
"Mercedes-AMG GT\n" +
"MINI\n" +
"\n" +
"MINI\n" +
"COUNTRYMAN\n" +
"PACEMAN\n" +
"CLUBMAN\n" +
"MITSUBISHI\n" +
"\n" +
"Montero\n" +
"I-MiEV\n" +
"ASX\n" +
"Outlander\n" +
"Space Star\n" +
"L200\n" +
"MORGAN\n" +
"\n" +
"Roadster\n" +
"Plus 8\n" +
"Plus 4\n" +
"4/4\n" +
"NISSAN\n" +
"\n" +
"X-TRAIL\n" +
"QASHQAI\n" +
"NOTE\n" +
"LEAF\n" +
"Pathfinder\n" +
"EVALIA\n" +
"Navara\n" +
"Micra\n" +
"JUKE\n" +
"370Z\n" +
"NV200\n" +
"GT-R\n" +
"PULSAR\n" +
"Murano\n" +
"NV200 EVALIA\n" +
"E-NV200 EVALIA\n" +
"OPEL\n" +
"\n" +
"Corsa\n" +
"Astra\n" +
"Meriva\n" +
"Zafira Tourer\n" +
"Zafira\n" +
"Insignia\n" +
"Combo\n" +
"Ampera\n" +
"Mokka\n" +
"Adam\n" +
"Cabrio\n" +
"Antara\n" +
"Karl\n" +
"GTC\n" +
"GTC\n" +
"Mokka\n" +
"Zafira\n" +
"Crossland X\n" +
"Mokka X\n" +
"PEUGEOT\n" +
"\n" +
"308\n" +
"807\n" +
"Bipper\n" +
"508\n" +
"Partner\n" +
"3008\n" +
"208\n" +
"2008\n" +
"RCZ\n" +
"5008\n" +
"4008\n" +
"108\n" +
"207\n" +
"Ion\n" +
"Traveller\n" +
"PORSCHE\n" +
"\n" +
"911\n" +
"Boxster\n" +
"Cayenne\n" +
"Panamera\n" +
"918\n" +
"Macan\n" +
"Cayman\n" +
"718\n" +
"RENAULT\n" +
"\n" +
"Fluence\n" +
"Grand Scénic\n" +
"Latitude\n" +
"Clio\n" +
"Scénic\n" +
"Laguna\n" +
"Kangoo Combi\n" +
"Mégane\n" +
"Grand Kangoo Combi\n" +
"Captur\n" +
"ZOE\n" +
"Koleos\n" +
"Twingo\n" +
"Espace\n" +
"Kadjar\n" +
"Talisman\n" +
"ROLLS-ROYCE\n" +
"\n" +
"Phantom\n" +
"SEAT\n" +
"\n" +
"Ibiza\n" +
"Nuevo León\n" +
"Alhambra\n" +
"Altea\n" +
"Mii\n" +
"Toledo\n" +
"Altea XL\n" +
"Ateca\n" +
"León\n" +
"Nuevo Ibiza\n" +
"SKODA\n" +
"\n" +
"Octavia\n" +
"Fabia\n" +
"Roomster\n" +
"Yeti\n" +
"Superb\n" +
"Citigo\n" +
"Rapid\n" +
"Spaceback\n" +
"Scout\n" +
"Kodiaq\n" +
"SMART\n" +
"\n" +
"Fortwo\n" +
"Forfour\n" +
"SSANGYONG\n" +
"\n" +
"Rexton\n" +
"Rodius\n" +
"Korando\n" +
"Actyon Sports Pick Up\n" +
"Tivoli\n" +
"XLV\n" +
"SUBARU\n" +
"\n" +
"Forester\n" +
"XV\n" +
"Outback\n" +
"BRZ\n" +
"WRX STI\n" +
"LEVORG\n" +
"WRX STI\n" +
"SUZUKI\n" +
"\n" +
"Grand Vitara\n" +
"Swift\n" +
"SX4\n" +
"Jimny\n" +
"SX4 S-Cross\n" +
"Celerio\n" +
"Kizashi\n" +
"Vitara\n" +
"Baleno\n" +
"Ignis\n" +
"TATA\n" +
"\n" +
"Xenon\n" +
"Aria\n" +
"Vista\n" +
"TESLA\n" +
"\n" +
"Model X\n" +
"Model S\n" +
"TOYOTA\n" +
"\n" +
"Avensis\n" +
"Land Cruiser\n" +
"Yaris\n" +
"Verso\n" +
"Auris\n" +
"Prius+\n" +
"GT86\n" +
"Prius\n" +
"Rav4\n" +
"Aygo\n" +
"Hilux\n" +
"Land Cruiser 200\n" +
"Proace Verso\n" +
"C-HR\n" +
"VOLKSWAGEN\n" +
"\n" +
"Polo\n" +
"Jetta\n" +
"Phaeton\n" +
"Golf\n" +
"Touran\n" +
"Touareg\n" +
"Beetle\n" +
"Sharan\n" +
"Tiguan\n" +
"Multivan\n" +
"California\n" +
"Caravelle\n" +
"Up!\n" +
"CC\n" +
"Golf Sportsvan\n" +
"Amarok\n" +
"Caddy\n" +
"Transporter\n" +
"Scirocco\n" +
"Passat\n" +
"Eos\n" +
"Arteon\n" +
"VOLVO\n" +
"\n" +
"V70\n" +
"S80\n" +
"XC70\n" +
"V60\n" +
"S60\n" +
"XC90\n" +
"XC60\n" +
"V40\n" +
"V40 Cross Country\n" +
"V60 Cross Country\n" +
"S60 Cross Country\n" +
"S90\n" +
"V90\n" +
"V90 Cross Country";
    
}
