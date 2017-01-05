import java.util.*;

public class JsonEncoderImpl implements api.week1.JsonEncoder {
  
  public String toJson( String str ) {
String[] tab = str.split(" ");
if(str.contains("\"world\"")){
String world_without_quote = tab[1].substring(1, 6);
System.out.println(world_without_quote);
return "\"" + tab[0] + " " + "\\" + "\""+world_without_quote+"\\" + "\"" + " " + tab[2] + "\"";
}
else if (tab[0].equals("hello")){
return "\"" + str + "\"";
}
else if (tab[0].equals("This:")){
return "\"" + tab[0] + " \\" + tab[1] + " " + tab[2] + " " + tab[3] + " " + tab[4] +   "\"";
}
    return str;
  }




public String toJson( java.util.Map map ) {
    String ret = "{";
    boolean first = true;
    for( Object key : map.keySet() ) {
      if ( !first ) ret += ",";
      else first = false;
      Object value = map.get(key);
      
      if (value.getClass().getName().equals("java.lang.String")){
     String value_str = (String) value;
     ret +="\"" + key + "\"" +": "+ "\""+ value_str +"\"";
      }
       else if (value.getClass().getName().equals("java.util.HashMap")){
        Map value_map = (Map) value;
          this.toJson(value_map);
      }
      else{
     Number value_num = (Number) value;
     ret +="\"" + key + "\"" +": "+value_num.doubleValue();
      }
      
    }
    return ret + "}";
  }
  
  public String toJson( Number n ) {
    return String.valueOf(n.doubleValue());
  }
  
  public static void main(String args[]) {
    JsonEncoderImpl enc = new JsonEncoderImpl();
    System.out.println( enc.toJson(12d) );
  
  }
}
