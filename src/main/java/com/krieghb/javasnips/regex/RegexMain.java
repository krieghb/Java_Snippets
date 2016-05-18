package com.krieghb.javasnips.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by krido02 on 5/2/2016.
 * 
 *  Playground for regex.
 */
@SuppressWarnings("unused")
public class RegexMain {

    Logger logger = LoggerFactory.getLogger(RegexMain.class);

    public boolean testReg() {
        boolean isPresent = false;
        
        String search2 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO 8009188365123400654";
        String search3 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO 09141998H0001579826200000239";
        String search4 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO L09141998H0002579826200000239";
        String search5 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO 09141998H0002479826200000239";

        
        String ctPattern = "((0[1-9])|(1[0-9])|(2[0-4]))[0-9]{7}";
        String coPattern1 = "(\\d{2}-?((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6]))-?\\d{4})";
        String coPattern2 = "([a-zA-Z]\\d{3,6})";
        String wbPattern = "\b80[0-9]|81[0-6][0-9]{2}\b|\b80[0-9]|81[0-6][0-9]{2}[0-9]{4}\b";

        String anotherTest = "(123[0-2]|456[4-6][8-9]{2})";
        String anotherWord = "123088";

        String boundaryTest = "\\b\\d[ab]{2}|[cd]\\d\\b";
        String boundaryWord = "5ab";

        
        
        String word_test = "\\b((80[0-9])|(81[0-6]))[0-9]{2}\\b";
        String word_test2 = "\\b80[0-9]|81[0-6][0-9]{2}\\b";
        String word_test3 = "\\b((80[0-9])|(81[0-6]))[0-9]{2}\\b";
        //527|6[01][0-9]|62[3-9]|634[0-9]{2}
        String noParanPat= "\\b527|6[01][0-9]|62[3-9]|634[0-9]{2}\\b";
        String withParanPat= "(\\b(((527)|(6[01][0-9])|(62[3-9])|(634))[0-9]{2})\\b)";

        String wordPost = "PRE63445";
        String wordPre = "52712POST";
        String wordMid1 = "PRE60111POST";
        String wordMid2 = "PRE6234555555POST";
    
        String two = "(\\d{2}((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6]))\\d{4})";
        String col = "883017595";
        

        String phonePattern = "( (?:(?<![\\d-]) (?:\\+?\\d{1,3}[-\\.\\s*]?)? (?:\\(?(\\d{3})\\)? [-\\.\\s*]?) \\d{3}[-\\.\\s*]?\\d{4}(?![\\d-]))|(?:(?<![\\d-])(?:(?:\\(\\+?\\d{2}\\))|(?:\\+?\\d{2}))\\s*\\d{2}\\s*\\d{3}\\s*\\d{4}(?![\\d-])))";

        // Create a Pattern object
        Pattern regPattern = Pattern.compile(two);

        // Now create matcher object.
        Matcher regMatcher = regPattern.matcher(col);
        
        
        logger.info("Group Count:  " + regMatcher.groupCount());
        if (regMatcher.find( )) {
            isPresent = true;
            
            for (int i = 0; i <= regMatcher.groupCount(); i++) {
                logger.info("FOUND MATCH:  '{}';  \t\t  in group #{}", regMatcher.group(i), i );
            }
        }
        else {
            logger.info("NO MATCH to '{}'", regPattern.pattern());
        }
        return isPresent;
    }


    public void testLookaheads() {
        String posLookAhead = "q(?=u)\\w{2,}";
        String negLookAhead = "q(?!u)\\w{2,}";
        String posConsLookAhead = "q(?:u)\\w{2,}";
        String posLookBehind = "(?<=q)u\\w{2,}";
        String negLookBehind = "(?<!q)u\\w{2,}";
        String myString = "QuIt your complaining qortermain unit.";

        String testLookAhead = "^(?!000)(?!666)(?!9)\\d{3}([- ]?)(?!00)\\d{2}\\1(?!0000)\\d{4}$";
        String myNumber = "023 45 7896";
        String myNumber2 = "13b12g12a11c00a11b11";


        String backRef = "(\\d\\d)[abc]\\1";

        String newYorkOrig = "([0-9]{9})|([0-9]{3} [0-9]{3} [0-9]{3})";
        String newYorkBack = "(([0-9]{3}(?<space>[ ]?)[0-9]{3}\\k<space>[0-9]{3}))";
        String newYorkStr = "0a12345678";

        String birthdateOrig = "[0-9][\\. /-][0-9][\\. /-][0-9]{2}|[0-9][\\. /-][0-9]{2}[\\. /-][0-9]{2}|[0-9]{2}[\\. /-][0-9][\\. /-][0-9]|[0-9]{2}[\\. /-][0-9][\\. /-][0-9]{2}|[0-9]{2}[\\. /-][0-9]{2}[\\. /-][0-9]|[0-9]{2}[\\. /-][0-9]{2}[\\. /-][0-9]{2}";
        String birthdateNew = "";
        String birthdateStr = "1.13.49";
        String birthdateStr2 = "13/13/1944";

        String birthdateTest = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        String birthdateTest2 = "^(?:(1[0-2]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])|(3[01]|[12][0-9]|0?[1-9])/(1[0-2]|0?[1-9]))/(?:[0-9]{2})?[0-9]{2}$";
        String birthdateTest3 = "^(?:((0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01]))|((0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])))/([0-9]{2})$";
        String birthdateTest4 = "(?:((0?[1-9]|1[0-2])(?<delims>[\\./-])(0?[1-9]|[12][0-9]|3[01]))|((0?[1-9]|[12][0-9]|3[01])\\k<delims>(0?[1-9]|1[0-2])))\\k<delims>([0-9]{2})";
        String birthdateTestJ = "(?:((0?[1-9]|1[0-2])({delims}[\\./-])(0?[1-9]|[12][0-9]|3[01]))|((0?[1-9]|[12][0-9]|3[01]){\\delims}(0?[1-9]|1[0-2]))){\\delims}([0-9]{2})";



        String birthday4  = "(?:((0?[1-9]|1[012])(?<delim>[\\./-])(0?[1-9]|[12][0-9]|3[01]))|((0?[1-9]|12[0-9]|3[01])\\k<delim>(0?[1-9]|1[012])))\\k<delim>[0-9]{4}";




        String birthdat4J = "(?:((0?[1-9]|1[012])({delim}[\\./-])(0?[1-9]|[12][0-9]|3[01]))|((0?[1-9]|12[0-9]|3[01]){\\delim}(0?[1-9]|1[012]))){\\delim}[0-9]{4}";


        //  using back ref (the \\3 references a previous group - rule of thumb, count open parenthesis in this case the [-])
        String colorBackRef = "((\\d{2}([-]?)((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6]))\\3\\d{4})|([a-zA-Z]\\d{6}))";
        String colorBackRefName = "((\\d{2}(?<dash>[-]?)((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6]))\\k<dash>\\d{4})|([a-zA-Z]\\d{6}))";
        String colorIsh = "123456789";

        String ohboy = "\\d{1,4} [a-zA-z\\s]{1,20}(?:ALLEY|Alley|ALLEE|Allee|ALY|Aly|ALLY|Ally|ANNEX|Annex|ANEX|Anex|ANX|Anx|ANNX|Annx|ARCADE|Arcade|ARC|Arc|AVENUE|Avenue|AV|Av|AVE|Ave|AVEN|Aven|AVENU|Avenu|AVN|Avn|AVNUE|Avnue|BAYOO|Bayoo|BYU|Byu|BAYOU|Bayou|BEACH|Beach|BCH|Bch|BEND|Bend|BND|Bnd|BLUFF|Bluff|BLF|Blf|BLUF|Bluf|BLUFFS|Bluffs|BLFS|Blfs|BOTTOM|Bottom|BOT|Bot|BTM|Btm|BOTTM|Bottm|BOULEVARD|Boulevard|BLVD|Blvd|BOUL|Boul|BOULV|Boulv|BRANCH|Branch|BR|Br|BRNCH|Brnch|BRIDGE|Bridge|BRDGE|Brdge|BRG|Brg|BROOK|Brook|BRK|Brk|BROOKS|Brooks|BRKS|Brks|BURG|Burg|BG|Bg|BURGS|Burgs|BGS|Bgs|BYPASS|Bypass|BYP|Byp|BYPA|Bypa|BYPAS|Bypas|BYPS|Byps|CAMP|Camp|CP|Cp|CMP|Cmp|CANYON|Canyon|CANYN|Canyn|CYN|Cyn|CNYN|Cnyn|CAPE|Cape|CPE|Cpe|CAUSEWAY|Causeway|CSWY|Cswy|CAUSWAY|Causway|CENTER|Center|CEN|Cen|CTR|Ctr|CENT|Cent|CENTR|Centr|CENTRE|Centre|CNTER|Cnter|CNTR|Cntr|CENTERS|Centers|CTRS|Ctrs|CIRCLE|Circle|CIR|Cir|CIRC|Circ|CIRCL|Circl|CRCL|Crcl|CRCLE|Crcle|CIRCLES|Circles|CIRS|Cirs|CLIFF|Cliff|CLF|Clf|CLIFFS|Cliffs|CLFS|Clfs|CLUB|Club|CLB|Clb|COMMON|Common|CMN|Cmn|CORNER|Corner|COR|Cor|CORNERS|Corners|CORS|Cors|COURSE|Course|CRSE|Crse|COURT|Court|CT|Ct|CRT|Crt|COURTS|Courts|CTS|Cts|COVE|Cove|CV|Cv|COVES|Coves|CVS|Cvs|CREEK|Creek|CK|Ck|CRK|Crk|CR|Cr|CRESCENT|Crescent|CRECENT|Crecent|CRES|Cres|CRESENT|Cresent|CRSCNT|Crscnt|CRSENT|Crsent|CRSNT|Crsnt|CREST|Crest|CRST|Crst|CROSSING|Crossing|XING|Xing|CRSSING|Crssing|CRSSNG|Crssng|CROSSROAD|Crossroad|XRD|Xrd|CURVE|Curve|CURV|Curv|DALE|Dale|DL|Dl|DAM|Dam|DM|Dm|DIVIDE|Divide|DIV|Div|DV|Dv|DVD|Dvd|DRIVE|Drive|DR|Dr|DRIV|Driv|DRV|Drv|DRIVES|Drives|DRS|Drs|ESTATE|Estate|EST|Est|ESTATES|Estates|ESTS|Ests|EXPRESSWAY|Expressway|EXP|Exp|EXPY|Expy|EXPR|Expr|EXPRESS|Express|EXPW|Expw|EXTENSION|Extension|EXT|Ext|EXTN|Extn|EXTNSN|Extnsn|EXTENSIONS|Extensions|EXTS|Exts|FALL|Fall|FALLS|Falls|FLS|Fls|FERRY|Ferry|FRY|Fry|FRRY|Frry|FIELD|Field|FLD|Fld|FIELDS|Fields|FLDS|Flds|FLAT|Flat|FLT|Flt|FLATS|Flats|FLTS|Flts|FORD|Ford|FRD|Frd|FORDS|Fords|FRDS|Frds|FOREST|Forest|FRST|Frst|FORESTS|Forests|FORGE|Forge|FORG|Forg|FRG|Frg|FORGES|Forges|FRGS|Frgs|FORK|Fork|FRK|Frk|FORKS|Forks|FRKS|Frks|FORT|Fort|FT|Ft|FRT|Frt|FREEWAY|Freeway|FWY|Fwy|FREEWY|Freewy|FRWAY|Frway|FRWY|Frwy|GARDEN|Garden|GDN|Gdn|GARDN|Gardn|GRDEN|Grden|GRDN|Grdn|GARDENS|Gardens|GDNS|Gdns|GRDNS|Grdns|GATEWAY|Gateway|GTWY|Gtwy|GATEWY|Gatewy|GATWAY|Gatway|GTWAY|Gtway|GLEN|Glen|GLN|Gln|GLENS|Glens|GLNS|Glns|GREEN|Green|GRN|Grn|GREENS|Greens|GRNS|Grns|GROVE|Grove|GROV|Grov|GRV|Grv|GROVES|Groves|GRVS|Grvs|HARBOR|Harbor|HARB|Harb|HBR|Hbr|HARBR|Harbr|HRBOR|Hrbor|HARBORS|Harbors|HBRS|Hbrs|HAVEN|Haven|HVN|Hvn|HAVN|Havn|HEIGHTS|Heights|HEIGHT|Height|HTS|Hts|HGTS|Hgts|HT|Ht|HIGHWAY|Highway|HWY|Hwy|HIGHWY|Highwy|HIWAY|Hiway|HIWY|Hiwy|HWAY|Hway|HILL|Hill|HL|Hl|HILLS|Hills|HLS|Hls|HOLLOW|Hollow|HLLW|Hllw|HOLW|Holw|HOLLOWS|Hollows|HOLWS|Holws|INLET|Inlet|INLT|Inlt|ISLAND|Island|IS|Is|ISLND|Islnd|ISLANDS|Islands|SS|Ss|I|SLNDS|Slnds|ISS|Iss|ISLE|Isle|ISLES|Isles|JUNCTION|Junction|JCT|Jct|JCTION|Jction|JCTN|Jctn|JUNCTN|Junctn|JUNCTON|Juncton|JUNCTIONS|Junctions|JCTNS|Jctns|JCTS|Jcts|KEY|Key|KY|Ky|KEYS|Keys|KYS|Kys|KNOLL|Knoll|KNL|Knl|KNOL|Knol|KNOLLS|Knolls|KNLS|Knls|LAKE|Lake|LK|Lk|LAKES|Lakes|LKS|Lks|LAND|Land|LANDING|Landing|LNDG|Lndg|LNDNG|Lndng|LANE|Lane|LA|La|LN|Ln|LANES|Lanes|LIGHT|Light|LGT|Lgt|LIGHTS|Lights|LGTS|Lgts|LOAF|Loaf|LF|Lf|LOCK|Lock|LCK|Lck|LOCKS|Locks|LCKS|Lcks|LODGE|Lodge|LDG|Ldg|LDGE|Ldge|LODG|Lodg|LOOP|Loop|LOOPS|Loops|MALL|Mall|MANOR|Manor|MNR|Mnr|MANORS|Manors|MNRS|Mnrs|MEADOW|Meadow|MDW|Mdw|MEADOWS|Meadows|MDWS|Mdws|MEDOWS|Medows|MEWS|Mews|MILL|Mill|ML|Ml|MILLS|Mills|MLS|Mls|MISSION|Mission|MSN|Msn|MISSN|Missn|MSSN|Mssn|MOTORWAY|Motorway|MTWY|Mtwy|MOUNT|Mount|MNT|Mnt|MT|Mt|MOUNTAIN|Mountain|MNTAIN|Mntain|MTN|Mtn|MNTN|Mntn|MOUNTIN|Mountin|MTIN|Mtin|MOUNTAINS|Mountains|MNTNS|Mntns|MTNS|Mtns|NECK|Neck|NCK|Nck|ORCHARD|Orchard|ORCH|Orch|ORCHRD|Orchrd|OVAL|Oval|OVL|Ovl|OVERPASS|Overpass|OPAS|Opas|PARK|Park|PK|Pk|PRK|Prk|PARKS|Parks|PARKWAY|Parkway|PKWY|Pkwy|PARKWY|Parkwy|PKWAY|Pkway|PKY|Pky|PARKWAYS|Parkways|PKWYS|Pkwys|PASS|Pass|PASSAGE|Passage|PSGE|Psge|PATH|Path|PATHS|Paths|PIKE|Pike|PIKES|Pikes|PINE|Pine|PNE|Pne|PINES|Pines|PNES|Pnes|PLACE|Place|PL|Pl|PLAIN|Plain|PLN|Pln|PLAINS|Plains|PLAINES|Plaines|PLNS|Plns|PLAZA|Plaza|PLZ|Plz|PLZA|Plza|POINT|Point|PT|Pt|POINTS|Points|PTS|Pts|PORT|Port|PRT|Prt|PORTS|Ports|PRTS|Prts|PRAIRIE|Prairie|PR|Pr|PRARIE|Prarie|PRR|Prr|RADIAL|Radial|RAD|Rad|RADL|Radl|RADIEL|Radiel|RAMP|Ramp|RANCH|Ranch|RNCH|Rnch|RANCHES|Ranches|RNCHS|Rnchs|RAPID|Rapid|RPD|Rpd|RAPIDS|Rapids|RPDS|Rpds|REST|Rest|RST|Rst|RIDGE|Ridge|RDG|Rdg|RDGE|Rdge|RIDGES|Ridges|RDGS|Rdgs|RIVER|River|RIV|Riv|RIVR|Rivr|RVR|Rvr|ROAD|Road|RD|Rd|ROADS|Roads|RDS|Rds|ROUTE|Route|RTE|Rte|ROW|Row|RUE|Rue|RUN|Run|SHOAL|Shoal|SHL|Shl|SHOALS|Shoals|SHLS|Shls|SHORE|Shore|SHOAR|Shoar|SHR|Shr|SHORES|Shores|SHOARS|Shoars|SHRS|Shrs|SKYWAY|Skyway|SKWY|Skwy|SPRING|Spring|SPG|Spg|SPNG|Spng|SPRNG|Sprng|SPRINGS|Springs|SPGS|Spgs|SPNGS|Spngs|SPRNGS|Sprngs|SPUR|Spur|SPURS|Spurs|SQUARE|Square|SQ|Sq|SQR|Sqr|SQRE|Sqre|SQU|Squ|SQUARES|Squares|SQRS|Sqrs|SQS|Sqs|STATION|Station|STA|Sta|STATN|Statn|STN|Stn|STRAVENUE|Stravenue|STRA|Stra|STRAV|Strav|STRAVE|Strave|STRAVEN|Straven|STRAVN|Stravn|STRVN|Strvn|STRVNUE|Strvnue|STREAM|Stream|STRM|Strm|STREME|Streme|STREET|Street|ST|St|STR|Str|STRT|Strt|STREETS|Streets|STS|Sts|SUMMIT|Summit|SMT|Smt|SUMIT|Sumit|SUMITT|Sumitt|TERRACE|Terrace|TER|Ter|TERR|Terr|THROUGHWAY|Throughway|TRWY|Trwy|TRACE|Trace|TRCE|Trce|TRACES|Traces|TRACK|Track|TRAK|Trak|TRACKS|Tracks|TRK|Trk|TRKS|Trks|TRAFFICWAY|Trafficway|TRFY|Trfy|TRAIL|Trail|TR|Tr|TRL|Trl|TRAILS|Trails|TRLS|Trls|TUNNEL|Tunnel|TUNEL|Tunel|TUNL|Tunl|TUNLS|Tunls|TUNNELS|Tunnels|TUNNL|Tunnl|TURNPIKE|Turnpike|TPK|Tpk|TPKE|Tpke|TRNPK|Trnpk|TRPK|Trpk|TURNPK|Turnpk|UNDERPASS|Underpass|UPAS|Upas|UNION|Union|UN|Un|UNIONS|Unions|UNS|Uns|VALLEY|Valley|VLY|Vly|VALLY|Vally|VLLY|Vlly|VALLEYS|Valleys|VLYS|Vlys|VIADUCT|Viaduct|VDCT|Vdct|IA|Ia|VIA|Via|VIADCT|Viadct|VIEW|View|VW|Vw|VIEWS|Views|VWS|Vws|VILLAGE|Village|VILL|Vill|VLG|Vlg|VILLAG|Villag|VILLG|Villg|VILLIAGE|Villiage|VILLAGES|Villages|VLGS|Vlgs|VILLE|Ville|VL|Vl|VISTA|Vista|VIS|Vis|VIST|Vist|VST|Vst|VSTA|Vsta|WALK|Walk|WALKS|Walks|WALL|Wall|WAY|Way|WY|Wy|WAYS|Ways|WELL|Well|WL|Wl|WELLS|Wells|WLS|Wls)\\W?(?=\\s|$)";


        String patternCaseIns = "((?i)(q(?=u)\\w{2,})) your";
        String whoopPattern = "WHOOP";



        jregex.Pattern jPattern = new jregex.Pattern(birthdat4J);
        jregex.Matcher jMatcher = jPattern.matcher(birthdateStr2);
        Pattern compliedPattern = Pattern.compile(birthday4);
        Matcher matched = compliedPattern.matcher(birthdateStr2);

        if (matched.find()) {
//            for (int i = 0; i <= matched.groupCount(); i++) {
                logger.info("Found match:  '{}';\t\tin group #{}", matched.group(0), 0);
//            }
        }
        else {
            logger.info("NO MATCH to '{}'", compliedPattern.pattern());
        }

        if (jMatcher.find()) {
            logger.info("JREGEX Found a match too:  {}", jMatcher.group(0));
        }
        else {
            logger.info("JEREGX Found NO MATCH to '{}'", jPattern.toString());
        }
    }



    public void testLoop() {

        List<String> myArray = new ArrayList<>();
        myArray.add("1");
        myArray.add("2");
        myArray.add("3");
        myArray.add("4");
        myArray.add("5");
        myArray.add("6");


        for (int i = 0; i < myArray.size(); i++) {
            if (i != myArray.size() - 1) {
                logger.info("Not the last!:  {}", myArray.get(i));
            }
            else {
                logger.info("It's the LAST!: {}", myArray.get(i));
            }
        }



    }


}
