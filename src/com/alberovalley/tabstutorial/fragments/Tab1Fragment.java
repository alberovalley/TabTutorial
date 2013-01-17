package com.alberovalley.tabstutorial.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.alberovalley.tabstutorial.R;
import com.alberovalley.tabstutorial.TabsFragmentActivity;
import com.handlerexploit.prime.widgets.RemoteImageView;

public class Tab1Fragment extends SherlockFragment {
	private RemoteImageView foto;
	private static final String remoteImgUrl 
	= "http://grimoriodelchef.files.wordpress.com/2013/01/wpid-img_20130104_151946.jpg";

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
		View root = inflater.inflate(R.layout.tab_frag1_layout, container, false);
		foto = (RemoteImageView) root.findViewById(R.id.tab1_img);
		return root;
	}

	@Override
	public void onResume() {
		super.onResume();
		// cargamos la imagen remota en asíncrono, sin bloquear el hilo de la UI
		Log.d("TabTutorial", "Cargando imagen remota " + remoteImgUrl);
		foto.setImageURL(remoteImgUrl);

	}

}