package com.example.issuetrack;

public class Data {

    private int Number;
    private String Title;

    private String Description;

    private String Created;

    private String Updated;

    private String Status;

    public Data(int Number,String Title,String Description,String Created, String Updated, String Status){
        this.Number= Number;
        this.Title=Title;
        this.Description=Description;
        this.Created=Created;
        this.Updated=Updated;
        this.Status=Status;
    }


    public Integer getNumber(){
        return Number;
    }
    public String getTitle(){
        return Title;
    }
    public String getDescription(){
        return Description;
    }

    public String getCreated(){
        return Created;
    }

    public String getUpdated(){
        return Updated;
    }

    public String getStatus(){
        return Status;
    }

}
