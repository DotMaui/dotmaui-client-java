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
package dotmaui.client.models;

import java.util.List;

/**
 *
 * @version 1.1
 * @author .Maui
 *
 */
public class MinifyRequest {

    public MinifyRequest() {
    }

    public MinifyRequest(int mode, int type, List<String> urls, String name) {
        this.mode = mode;
        this.type = type;
        this.urls = urls;
        this.name = name;
    }
    
    public MinifyRequest(int mode, int type, String string, String name) {
        this.mode = mode;
        this.type = type;
        this.string = string;
        this.name = name;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private int mode;

    /**
     * Get the value of mode
     *
     * @return the value of mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * Set the value of mode
     *
     * @param mode new value of mode
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    private int type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public int getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(int type) {
        this.type = type;
    }

    private List<String> urls;

    /**
     * Get the value of urls
     *
     * @return the value of urls
     */
    public List<String> getUrls() {
        return urls;
    }

    /**
     * Set the value of urls
     *
     * @param urls new value of urls
     */
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    private String string;

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(String string) {
        this.string = string;
    }

}
