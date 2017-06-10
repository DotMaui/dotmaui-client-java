package dotmaui.client.models;

/**
 *
 * @author .Maui
 */
public class ImgResizerRequest {

    private String url;
    private int width;
    private int height;

    public ImgResizerRequest(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }
    
    public ImgResizerRequest(String url) {
        this.url = url;
        this.width = 0;
        this.height = 0;
    }    

    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the value of width
     *
     * @return the value of width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the value of width
     *
     * @param width new value of width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the value of url
     *
     * @return the value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the value of url
     *
     * @param url new value of url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
