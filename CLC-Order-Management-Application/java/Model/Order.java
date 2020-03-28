package Model;

/**
 * Order class.
 * @author Cameron Deao & John Harrison
 *
 */
public class Order
{
    private int id;
    private int user_id;
    private String item; 
    private double total;
    private String card_last_four;
    private String description; // List of items ordered
    private String status; // Placed, Reviewed, Shipped, In-Transit, Delivered

    public Order()
    {

    }

    /**
     * Order()
     * @param user_id
     * @param item
     * @param total
     * @param card_last_four
     * @param description
     * @param status
     */
    public Order(int user_id, String item, double total, String card_last_four, String description, String status)
    {
        this.user_id = user_id;
        this.item = item;
        this.total = total;
        this.card_last_four = card_last_four;
        this.description = description;
        this.status = status;
    }

    /**
     * getId()
     * @return
     */
    public int getId()
    {
        return id;
    }

    /**
     * setId()
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * getUser_id()
     * @return
     */
    public int getUser_id()
    {
        return user_id;
    }

    /**
     * setUser_id()
     * @param user_id
     */
    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    /**
     * getItem()
     * @return
     */
    public String getItem()
    {
        return item;
    }

    /**
     * setItem()
     * @param item
     */
    public void setItem(String item)
    {
        this.item = item;
    }

    /**
     * getTotal()
     * @return
     */
    public double getTotal()
    {
        return total;
    }

    /**
     * setTotal()
     * @param total
     */
    public void setTotal(double total)
    {
        this.total = total;
    }

    /**
     * getCard_last_four()
     * @return
     */
    public String getCard_last_four()
    {
        return card_last_four;
    }

    /**
     * setCard_last_four()
     * @param card_last_four
     */
    public void setCard_last_four(String card_last_four)
    {
        this.card_last_four = card_last_four;
    }

    /**
     * getDescription()
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * setDescription()
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * getStatus()
     * @return
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * setStatus()
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
}
