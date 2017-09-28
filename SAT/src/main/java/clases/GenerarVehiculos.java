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
public class GenerarVehiculos {
    public static void main(String args[]){
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
