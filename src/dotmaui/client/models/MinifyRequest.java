/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotmaui.client.models;

import java.util.List;

/**
 *
 * @author maui
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
