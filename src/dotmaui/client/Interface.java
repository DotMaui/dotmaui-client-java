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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @version 1.1
 * @author .Maui
 *
 */
public class Interface {

    public static String apiRequest(String urlApi, String urlParameters) throws MalformedURLException, IOException {

        URL obj = new URL(urlApi);
        String result;
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        con.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            result = reader.lines().collect(Collectors.joining("\n"));
        }

        return result;

    }

    public static String downloadFromUrl(String url_req) {

        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        String content = "";

        try {
            url = new URL(url_req);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                content += line;
            }
        } catch (MalformedURLException mue) {
            return null;
        } catch (IOException ioe) {
            return null;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

        return content;
    }
}
