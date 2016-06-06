package com.example.niva.listex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList <ListObject> listItem;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById (R.id.listView) ; // Create the ArrayList that will allow us to fill the listView
        listItem = createList();

        adapter = new CustomAdapter(getApplicationContext(), R.layout.display_item, listItem);
        listView.setAdapter(adapter) ;


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final ListObject object = (ListObject)listView.getItemAtPosition(position) ; // we create a dialog
                AlertDialog.Builder adb = new AlertDialog. Builder ( MainActivity.this ) ; // a title we attribute to our dialog

                adb. setTitle("Select Item") ; // inserting a message to our dialog, and here we show the under item clicked
                adb. setMessage("Remove: " + object.getTitle() + "?") ; // we indicate that we want the ok button on our dialog
                adb.setCancelable(true);

                adb. setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listItem.remove(object);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb. setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


                AlertDialog alertDialog = adb.create();

                alertDialog.show();
            }
        });

    }


    ArrayList<ListObject> createList() {
        ArrayList<ListObject> listItem = new ArrayList<ListObject> ( ) ;

        ListObject object = new ListObject("Word", "Editor",(R.drawable.wordicon));
        listItem.add(object);

        object = new ListObject("PowerPoint", "Editor",(R.drawable.ppicon));
        listItem.add(object);

        object = new ListObject("Excel", "Editor",(R.drawable.excelicon));
        listItem.add(object);

        object = new ListObject("Outlook", "mail",(R.drawable.outlookicon));
        listItem.add(object);

        return listItem;
    }

}
