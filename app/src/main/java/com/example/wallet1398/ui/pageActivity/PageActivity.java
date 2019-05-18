package com.example.wallet1398.ui.pageActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.wallet1398.R;
import com.example.wallet1398.ui.createwallet.CreateWalletActivity;
import com.example.wallet1398.ui.exchange.ExchangeActivity;
import com.example.wallet1398.ui.listcurrencies.CurrenciesActivity;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;



public class PageActivity extends AppCompatActivity implements PageInterface.View {
    Toolbar toolbar;
    boolean doubleBackToExitPressedOnce = false;
    Drawer result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageactivity);
        init();
        drawer();
        sharedPreferences();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState = result.saveInstanceState(outState);


        super.onSaveInstanceState(outState);
    }


    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {

            super.onBackPressed();
            return;
        }
        result.closeDrawer();
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.doubleback, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public void init() {
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        new DrawerBuilder().withActivity(this).build();
    }


    @Override
    public void drawer() {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName(R.string.profile1).withEmail(R.string.Email1).withIcon(getResources().getDrawable(R.drawable.profile)),
                        new ProfileDrawerItem().withName(R.string.profile2).withEmail(R.string.Email2).withIcon(getResources().getDrawable(R.drawable.add92525ab635b5119671269d24c1449))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        switch (view.getId()) {
                            case R.drawable.profile:
                                Toast.makeText(PageActivity.this, R.string.profile1, Toast.LENGTH_SHORT).show();
                            case R.drawable.add92525ab635b5119671269d24c1449:
                                Toast.makeText(PageActivity.this, R.string.profile2, Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                })
                .build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("List").withSelectable(false);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Wallet").withSelectable(false);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("change").withSelectable(false);
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withCloseOnClick(true)
                .withDisplayBelowStatusBar(false)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {


                                                       switch (position) {
                                                           case 1:
                                                               Intent intent = new Intent(PageActivity.this, CurrenciesActivity.class);
                                                               startActivity(intent);

                                                               break;
                                                           case 2:
                                                               Intent intent1 = new Intent(PageActivity.this, CreateWalletActivity.class);
                                                               startActivity(intent1);
                                                               break;
                                                           case 3:
                                                               Intent intent2 = new Intent(PageActivity.this, ExchangeActivity.class);
                                                               startActivity(intent2);
                                                       }

                                                       return false;

                                                   }
                                               }

                ).build();

    }

    @Override
    public void sharedPreferences() {
        final SharedPreferences.Editor editor = getSharedPreferences("login", MODE_PRIVATE).edit();
        editor.putBoolean("login", false);
        editor.commit();
        editor.clear();
        editor.putBoolean("login", true);
        editor.commit();

    }
}
