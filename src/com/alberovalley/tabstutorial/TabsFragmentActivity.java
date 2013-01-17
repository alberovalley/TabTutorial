package com.alberovalley.tabstutorial;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.alberovalley.tabstutorial.fragments.Tab1Fragment;
import com.alberovalley.tabstutorial.fragments.Tab2Fragment;
import com.alberovalley.tabstutorial.fragments.Tab3Fragment;

public class TabsFragmentActivity extends SherlockFragmentActivity implements TabListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Obtenemos la barra de esta actividad 
		ActionBar bar = getSupportActionBar(); // sin Sherlock sería getActionBar()

		// Creamos tantas tabs como vayamos a necesitar
		ActionBar.Tab tab1 = bar.newTab();
		ActionBar.Tab tab2 = bar.newTab();
		ActionBar.Tab tab3 = bar.newTab();
		// asignamos una etiqueta (setText) y una identificación (setTag) a cada una. 
		tab1.setText("Foto");
		tab1.setTag("Foto");
		
		tab2.setText("Datos");
		tab2.setTag("Datos");
		
		tab3.setText("Comentarios");
		tab3.setTag("Comentarios");
		
		// Se puede asignar un icono a cada pestaña con tab1.setIcon(Drawable icon)
		
		// añadimos el Listener para cuando activemos las tabs
		tab1.setTabListener(this);
		tab2.setTabListener(this);
		tab3.setTabListener(this);
		
		// con todo listo, asignamos las tabs a la barra
		bar.addTab(tab1);
		bar.addTab(tab2);
		bar.addTab(tab3);
		
		// activar el modo de navegación por pestañas, 
		// mejor al final, para que no de problemas al rotar
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		String tag = (String) tab.getTag();
		Log.d("TabTutorial", "Elegido tab con tag: " + tag);
		// Creamos un Fragment nuevo (con new Fragment) del tipo adecuado según la elección
		// y reemplazamos lo que hubiera antes usando 
		// el método replace del FragmentTransition que recibe este método
		if (tag.equalsIgnoreCase("Foto")){
			Tab1Fragment frag = new Tab1Fragment();
			ft.replace(android.R.id.content, frag);
		}else if (tag.equalsIgnoreCase("Datos")){
			Tab2Fragment frag = new Tab2Fragment();
			ft.replace(android.R.id.content, frag);
		}else if (tag.equalsIgnoreCase("Comentarios")){
			Tab3Fragment frag = new Tab3Fragment();
			ft.replace(android.R.id.content, frag);
		}else{
			Log.w("TabTutorial", "tag de tab no registrada: " + tag);
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// si se necesita hacer algo especial cuando un fragment
		// deja de estar seleccionado
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// si se necesita hacer algo especial cuando un fragment
		// vuelve a ser seleccionado
	}
	
}
