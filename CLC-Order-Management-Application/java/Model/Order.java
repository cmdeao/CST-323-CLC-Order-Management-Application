package Model;

public class Order
{
    private int id;
    private int user_id;
    private String item; // TODO: Create Item model with name, price, description
    private double total;
    private String card_last_four;
    private String description; // List of items ordered
    private String status; // Placed, Reviewed, Shipped, In-Transit, Delivered

    public Order()
    {

    }

    public Order(int user_id, String item, double total, String card_last_four, String description, String status)
    {
        this.user_id = user_id;
        this.item = item;
        this.total = total;
        this.card_last_four = card_last_four;
        this.description = description;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public String getItem()
    {
        return item;
    }

    public void setItem(String item)
    {
        this.item = item;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public String getCard_last_four()
    {
        return card_last_four;
    }

    public void setCard_last_four(String card_last_four)
    {
        this.card_last_four = card_last_four;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
