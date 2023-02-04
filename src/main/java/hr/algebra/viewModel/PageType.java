package hr.algebra.viewModel;

public enum PageType {
    Home(0),
    Cart(1),
    Profile (2),
    LoginHistory (3),
    OrderHistory (4),
    ProductEditor (5),
    CategoryEditor (6),
    Register(-1),
    Login(-2),
    ORDER(-3);

    private final int value;

    PageType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public boolean isEqual(PageType type){
        return type.getValue() == value;
    }
}
