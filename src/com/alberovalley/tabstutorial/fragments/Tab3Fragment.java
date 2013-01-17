package com.alberovalley.tabstutorial.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.alberovalley.tabstutorial.R;

public class Tab3Fragment extends SherlockFragment {
	private ListView listaComentarios;
	private ArrayAdapter<String> listaAdapter;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			// Tenemos diferentes layouts, y en uno de ellos el frame 
			// que contiene este fragment no existe. El fragment
			// se puede aún crear desde su estado guardado, pero no hay
			// razón alguna para intentar crear su jerarquía de vistas ya que
			// no se mostrará. Notar que esto no es necesario - podríamos simplemente
			// ejecutar el código de debajo, dónde crearíamos y devolveríamos
			// la jerarquía de vistas; simplemente nunca se usaría
			return null;
		}
		View root = inflater.inflate(R.layout.tab_frag3_layout, container, false);
		listaComentarios = (ListView) root.findViewById(R.id.tab3_lista);
		listaAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
		listaComentarios.setAdapter(listaAdapter);
		return root;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		listaAdapter.add("Una receta fácil y deliciosa (Fulano)");
		listaAdapter.add("Gracias! Me encantan las trufas... y todo lo de chocolate xDDD (Mengan)");
		listaAdapter.add("Estoy deseando probarlas (Zut)");
		listaAdapter.add("Qué pintaza! Quierooooooooooo (Pereng)");

	}	
}