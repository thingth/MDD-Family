package mmm.mddfamily;

public class AddQuoteDatabase
{
    int id;
    String keyword;
    String response;

    public AddQuoteDatabase()
    {

    }

    public AddQuoteDatabase(String keyword, String response)
    {
        this.keyword = keyword;
        this.response = response;
    }

    public AddQuoteDatabase(int id, String keyword, String response)
    {
        this.id = id;
        this.keyword = keyword;
        this.response = response;
    }

    public int getId() { return id; }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getResponse() {
        return response;
    }
    public void setResponse(String response)
    {
        this.response = response;
    }

}
