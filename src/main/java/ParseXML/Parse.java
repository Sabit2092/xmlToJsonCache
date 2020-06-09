package ParseXML;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class Parse {

        public String convertXMLtoJSON(String XML_STRING) {
            String jsonPrettyPrintString = "";

            try {
                JSONObject xmlJSONObj = XML.toJSONObject(XML_STRING);
                jsonPrettyPrintString = xmlJSONObj.toString(4);
            } catch (JSONException je) {
                jsonPrettyPrintString = je.toString();
            }

            return jsonPrettyPrintString;
        }


}
