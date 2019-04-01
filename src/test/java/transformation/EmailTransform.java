package transformation;


import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String searchItem){
        return searchItem.concat("souspan");
    }
}
