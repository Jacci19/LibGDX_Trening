package pl.jacci.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import pl.jacci.ui.IRequestCallback;

public class FeatureFlagService {

    public static final String REQUEST_URL = "http://javadevmatt.pythonanywhere.com/tutorialclicker/api/v1.0/features";
    public static final String FEATURE_SHOP = "FEATURE_SHOP";

    private boolean shop = false;

    public void makeFeatureFlagsRequest(final IRequestCallback requestCallback){                                //https://youtu.be/ntVzGRIOvl4?list=PLFq6ri1W22hwmA0FzkR5zPPOnsimwUc9P&t=987
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(REQUEST_URL).build();         //wg wzorca projektowego builder (fluent builder)
        Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener() {

            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                System.out.println("Result:");
                System.out.println(httpResponse.getResultAsString());
                System.out.println("----------------------");

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


    //GETTERY

    public boolean hasShop() {
        return shop;
    }

    public void setShop(boolean shop) {
        this.shop = shop;
    }
}






















