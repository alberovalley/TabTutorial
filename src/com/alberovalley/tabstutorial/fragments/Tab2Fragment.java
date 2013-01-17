package com.alberovalley.tabstutorial.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.alberovalley.tabstutorial.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class Tab2Fragment extends SherlockFragment implements OnRatingBarChangeListener {
	private RatingBar puntuar;
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
		View root = inflater.inflate(R.layout.tab_frag2_layout, container, false);
		puntuar = (RatingBar) root.findViewById(R.id.tab2_puntuar);
		puntuar.setOnRatingBarChangeListener(this);
		return root;
	}
	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		Crouton.makeText(getActivity(), "Puntuación elegida: [" + rating +"]", Style.INFO).show();

	}
}


