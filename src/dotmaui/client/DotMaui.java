/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package dotmaui.client;

import static dotmaui.client.Interface.apiRequest;
import dotmaui.client.models.ImgResizerRequest;
import dotmaui.client.models.Modes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @version 1.1
 * @author .Maui
 *
 */
public class DotMaui {

    private final String APIKEY;
    private final String ENDPOINT = "https://api.dotmaui.com/client/";
    private final String CLIENT_VERSION;

    public String getAPIKEY() {
        return APIKEY;
    }

    public String getCLIENT_VERSION() {
        return CLIENT_VERSION;
    }

    public DotMaui(String apikey) {
        APIKEY = apikey;
        CLIENT_VERSION = "1.0";
    }

    public String MinifyCSSFromUrl(String url) throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/cssmin/";
        String urlParameters = "apikey=" + APIKEY + "&url=" + URLEncoder.encode(url, "UTF-8");

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyCSS(dotmaui.client.models.MinifyRequest req) throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/cssmin/";
        String urlParameters = "apikey=" + APIKEY;

        if (req.getUrls() != null && req.getUrls().size() > 0) {

            for (String url : req.getUrls()) {
                urlParameters += "&url[]=" + URLEncoder.encode(url, "UTF-8");
            }

        } else if (!"".equals(req.getString())) {
            urlParameters += "&css=" + URLEncoder.encode(req.getString(), "UTF-8");
        }

        if (req.getMode() == Modes.CDN) {
            urlParameters += "&mode=cdn";
        }
        
        if (req.getName() != null && !"".equals(req.getName().trim())) {
            urlParameters += "&name=" + req.getName();
        }

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyJSFromUrl(String url)
            throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/jsmin/";
        String urlParameters = "apikey=" + APIKEY + "&url=" + URLEncoder.encode(url, "UTF-8");

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyJS(dotmaui.client.models.MinifyRequest req) throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/jsmin/";
        String urlParameters = "apikey=" + APIKEY;

        if (req.getUrls() != null && req.getUrls().size() > 0) {

            for (String url : req.getUrls()) {
                urlParameters += "&url[]=" + URLEncoder.encode(url, "UTF-8");
            }

        } else if (!"".equals(req.getString())) {
            urlParameters += "&js=" + URLEncoder.encode(req.getString(), "UTF-8");
        }

        if (req.getMode() == Modes.CDN) {
            urlParameters += "&mode=cdn";
        }
        
        if (req.getName() != null && !"".equals(req.getName().trim())) {
            urlParameters += "&name=" + req.getName();
        }

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyHTMLFromUrl(String url)
            throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/htmlmin/";
        String urlParameters = "apikey=" + APIKEY + "&url=" + URLEncoder.encode(url, "UTF-8");

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyCSSFromString(String css) throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/cssmin/";
        String urlParameters = "apikey=" + APIKEY + "&css=" + URLEncoder.encode(css, "UTF-8");

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyJSFromString(String js)
            throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/jsmin/";
        String urlParameters = "apikey=" + APIKEY + "&js=" + URLEncoder.encode(js, "UTF-8");

        return apiRequest(urlApi, urlParameters);
    }

    public String MinifyHTMLFromString(String html)
            throws UnsupportedEncodingException, Exception {
        String urlApi = ENDPOINT + CLIENT_VERSION + "/htmlmin/";
        String urlParameters = "apikey=" + APIKEY + "&html=" + URLEncoder.encode(html, "UTF-8");

        return apiRequest(urlApi, urlParameters);
    }      
    
    public boolean SaveImgResizedFromUrl(ImgResizerRequest req, String saveLocation) {

        HttpClient httpClient = HttpClientBuilder.create().build();
        String urlApi = ENDPOINT + CLIENT_VERSION + "/imgresize/";
        boolean result = true;

        if (req == null) {
            throw new java.lang.Error("Req cannot be null");
        }

        if (req.getUrl() == null || req.getUrl().trim().equals("")) {
            throw new java.lang.Error("Url required");
        }

        if (req.getWidth() == 0 && req.getHeight() == 0) {
            throw new java.lang.Error("Height or width required");
        }

        ArrayList<NameValuePair> postParameters = new ArrayList<>();

        if (req.getWidth() != 0) {
            postParameters.add(new BasicNameValuePair("width", req.getWidth() + ""));
        }

        if (req.getHeight() != 0) {
            postParameters.add(new BasicNameValuePair("height", req.getHeight() + ""));
        }

        try {

            HttpPost request = new HttpPost(urlApi);
            postParameters.add(new BasicNameValuePair("apikey", APIKEY));
            postParameters.add(new BasicNameValuePair("url", req.getUrl()));

            request.setEntity(new UrlEncodedFormEntity(postParameters));

            HttpResponse response = httpClient.execute(request);

            try ( // write the inputStream to a FileOutputStream
                    OutputStream outputStream = new FileOutputStream(new File(saveLocation))) {
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = response.getEntity().getContent().read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }

        } catch (IOException | UnsupportedOperationException e) {
            result = false;
        }

        return result;

    }

}
