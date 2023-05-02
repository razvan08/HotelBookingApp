package com.example.currentaddress;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.currentaddress.models.Customer;
import com.example.currentaddress.models.Reservation;
import com.example.currentaddress.storage.Database;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Booking extends AppCompatActivity {

    Button bookingbtn;
    Spinner roomSpinner;
    private EditText name, phno, email, staydays, pin;
    private DatePicker datePicker;
    private String cname,  cphno, cemail, crooms, cstaydays, cpin;
    private Database database;
    private String cStartDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        database = new Database(this);

        name = (EditText) findViewById(R.id.customer_name);
        phno = (EditText) findViewById(R.id.customer_phone);
        email = (EditText) findViewById(R.id.customer_email);
        roomSpinner = (Spinner) findViewById(R.id.room_spinner);
        staydays = (EditText) findViewById(R.id.days);
        pin= (EditText) findViewById(R.id.customer_pin);
        bookingbtn = (Button) findViewById(R.id.cust_booking);
        datePicker = (DatePicker) findViewById(R.id.date_start_entered);

        final Intent intent = getIntent();
        final Reservation reservation = (Reservation) intent.getSerializableExtra("reservation");
        if(reservation!= null){
            name.setText(reservation.customer.getName());
            phno.setText(String.valueOf(reservation.customer.getPhone()));
            email.setText(reservation.customer.getEmail());

            ArrayAdapter myAdap1 = (ArrayAdapter) roomSpinner.getAdapter(); //cast to an ArrayAdapter
            int spinnerPosition = myAdap1.getPosition(reservation.reserved_room.getRoom_type().getRoom_type());
            roomSpinner.setSelection(spinnerPosition);

            staydays.setText(String.valueOf(reservation.getNo_of_days()));
            pin.setText(String.valueOf(reservation.customer.getPin()));

        }
        bookingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDataEntered()) {
                    final Reservation reservation = new Reservation();
                    reservation.customer.setName(cname);
                    reservation.customer.setPhone(Long.parseLong(cphno));
                    reservation.customer.setEmail(cemail);
                    reservation.reserved_room.getRoom_type().setRoom_type(crooms);
                    reservation.setNo_of_days(Integer.parseInt(cstaydays));
                    reservation.customer.setPin(Integer.parseInt(cpin));
                    reservation.setStart_date(cStartDate);
                    reservation.reserved_room.setAvailable(false);

                    database.addCustomer(Booking.this, reservation, new Database.DatabaseCallback() {
                        @Override
                        public void onCompletion(boolean success) {
                            if(success) {
                                Intent intent = new Intent(getApplicationContext(), BookingConfirmation.class);
                                intent.putExtra("reservation", reservation);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCustomersRetrieved(List<Reservation> reservations) {
                            //ToDo: Nothing
                        }

                    });
                } else {
                    checkDataEntered();
                }
            }
        });
    }

    public boolean checkDataEntered() {
        boolean valid = true;

        cname = name.getText().toString();
        cphno = phno.getText().toString();
        cemail= email.getText().toString();
        crooms = roomSpinner.getSelectedItem().toString().trim();
        cstaydays = staydays.getText().toString();
        cpin = pin.getText().toString();
        cStartDate = datePicker.getDayOfMonth() +"/"+datePicker.getMonth() +"/"+datePicker.getYear();


        if (cname.length() < 3 || cname.isEmpty()) {
            Toast toast = Toast.makeText(this, "Name should contain atleast 3 letters!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (cphno.length()!= 10 || cphno.isEmpty()) {
            Toast toast = Toast.makeText(this, "Number should have 10 digits", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (TextUtils.isEmpty(cemail) || !Patterns.EMAIL_ADDRESS.matcher(cemail).matches()) {
            Toast.makeText(this, "Enter valid email address!", Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (crooms.equalsIgnoreCase("Choose any") || crooms.isEmpty()) {
            Toast toast = Toast.makeText(this, "Choose any Room Type!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (cstaydays.length() == 0 || cphno.isEmpty()) {
            Toast toast = Toast.makeText(this, "Stay Days should be atleast 1", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (cpin.length() != 6 || cpin.isEmpty()) {
            Toast toast = Toast.makeText(this, "PIN should contain 6 digits ", Toast.LENGTH_LONG);
            toast.show();
            valid = false;
        }
        return valid;
    }
}
