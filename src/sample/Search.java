package sample;

public class Search {
    private  String txtsearch;

    public Search(String txtsearch) {
        this.txtsearch = txtsearch;
    }

    public String getTxtsearch() {
        return txtsearch;
    }

    public void setTxtsearch(String txtsearch) {
        this.txtsearch = txtsearch;
    }

    @Override
    public String toString() {
        return getTxtsearch();
    }
}
