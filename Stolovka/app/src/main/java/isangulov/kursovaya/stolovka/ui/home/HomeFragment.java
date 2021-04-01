package isangulov.kursovaya.stolovka.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import isangulov.kursovaya.stolovka.R;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;

    View v;
    RecyclerView recyclerView;
    List<Contact> listCont;

    public HomeFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        v = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleView);
        RecycleViewAdapter viewAdapter = new RecycleViewAdapter(getContext(), listCont);

        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        recyclerView.setAdapter(viewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCont = new ArrayList<>();
        listCont.add(new Contact("Щи","38.42 ₽", R.drawable.chi));
        listCont.add(new Contact("Плов","45.67 ₽",R.drawable.plov));
        listCont.add(new Contact("Картофельное пюре","19.50 ₽",R.drawable.puree));
        listCont.add(new Contact("Картошка","16.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Сосиска в тесте","23.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Лагман","34.23 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Рассольник","32.67₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Цыпленок табака","19.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Курица по гавайски","19.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Чай с лимоном","19.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Белый хлеб","19.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Кекс","19.50 ₽",R.drawable.ic_launcher_background));
        listCont.add(new Contact("Макароны отварные","19.50 ₽",R.drawable.ic_launcher_background));
    }
}