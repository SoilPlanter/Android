package soil.planter.android.Tools;

import java.util.ArrayList;

import soil.planter.android.Interfaces.Pagination;

public class Paginator {
    private ArrayList<Pagination> paginationArrayList = new ArrayList<>();
    public void initPagination(Pagination page) {
        paginationArrayList.add(page);

    }
}
