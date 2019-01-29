package pl.jacci.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.jacci.ui.IRequestCallback;

import java.util.HashMap;
import java.util.Map;

public class FeatureFlagService {

    public static final String REQUEST_URL = "http://javadevmatt.pythonanywhere.com/tutorialclicker/api/v1.0/features";
    public static final String FEATURE_SHOP = "FEATURE_SHOP";

    private Map<String, Boolean> featuresMap;

    public FeatureFlagService(){
        featuresMap = new HashMap<String, Boolean>();
    }

    public void makeFeatureFlagsRequest(final IRequestCallback requestCallback){                                //https://youtu.be/ntVzGRIOvl4?list=PLFq6ri1W22hwmA0FzkR5zPPOnsimwUc9P&t=987
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(REQUEST_URL).build();         //wg wzorca projektowego builder (fluent builder)
        Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener() {

            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {

                parseResponse(httpResponse.getResultAsString());
                requestCallback.onSucceed();
            }

            @Override
            public void failed(Throwable t) {
                System.out.println(t.getMessage());
                requestCallback.onError();
            }

            @Override
            public void cancelled() {
                requestCallback.onError();
            }
        });    }

    private void parseResponse(String resultAsString) {                         //tu parsowanie nie działa bo na serwerze Kupilasa nie ma już danych do tego kursu ( //https://youtu.be/9fIkdag8INU?list=PLFq6ri1W22hwmA0FzkR5zPPOnsimwUc9P&t=685)

        //System.out.println("___serwer M. Kupilasa:____\n" + resultAsString + "\n______________________");       //pokazuje zawrtość serwera M. Kupilasa

        try {
            JSONObject obj = new JSONObject(resultAsString);
            JSONArray jsonArray = obj.getJSONArray("features");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject innerObj = jsonArray.getJSONObject(i);
                featuresMap.put((String)innerObj.get("name"), (Boolean)innerObj.get("active"));
            }
            System.out.println("Parsed map: " + featuresMap);

        } catch (JSONException e) {
            //e.printStackTrace();
            System.out.println("Tu parsowanie danych z netu nie działa bo na serwerze M.Kupilasa nie ma już danych do tego kursu");
        }
    }


    public boolean hasFeature(String s){
        if(!featuresMap.containsKey(s)){    //Czy dany klucz jest w tej mapie
            return false;
        } else {
            return featuresMap.get(s);
        }
    }
}






















