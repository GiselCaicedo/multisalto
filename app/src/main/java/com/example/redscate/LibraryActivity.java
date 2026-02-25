package com.example.redscate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {
    private View modalOverlay;
    private TextView modalTitle;
    private TextView modalParagraph;
    private ImageView modalHeroImage;
    private LinearLayout modalItemRow1;
    private TextView modalItemTitle1;
    private TextView modalItemDesc1;
    private ImageView modalItemImg1;
    private LinearLayout modalItemRow2;
    private TextView modalItemTitle2;
    private TextView modalItemDesc2;
    private ImageView modalItemImg2;
    private LinearLayout modalDots;
    private Button modalPrev;
    private Button modalNext;
    private Button modalFinish;

    private List<LibrarySlide> currentSlides = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        findViewById(R.id.homeButton).setOnClickListener(v ->
                startActivity(new Intent(this, HomeActivity.class)));
        findViewById(R.id.profileButton).setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
        findViewById(R.id.helpButton).setOnClickListener(v ->
                startActivity(new Intent(this, AlertHomeActivity.class)));
        findViewById(R.id.bottomDocButton).setOnClickListener(v ->
                startActivity(new Intent(this, ChatActivity.class)));

        setupModalViews();
        setupCardActions();
    }

    private void setupModalViews() {
        modalOverlay = findViewById(R.id.modalOverlay);
        modalTitle = findViewById(R.id.modalTitle);
        modalParagraph = findViewById(R.id.modalParagraph);
        modalHeroImage = findViewById(R.id.modalHeroImage);
        modalItemRow1 = findViewById(R.id.modalItemRow1);
        modalItemTitle1 = findViewById(R.id.modalItemTitle1);
        modalItemDesc1 = findViewById(R.id.modalItemDesc1);
        modalItemImg1 = findViewById(R.id.modalItemImg1);
        modalItemRow2 = findViewById(R.id.modalItemRow2);
        modalItemTitle2 = findViewById(R.id.modalItemTitle2);
        modalItemDesc2 = findViewById(R.id.modalItemDesc2);
        modalItemImg2 = findViewById(R.id.modalItemImg2);
        modalDots = findViewById(R.id.modalDots);
        modalPrev = findViewById(R.id.modalPrev);
        modalNext = findViewById(R.id.modalNext);
        modalFinish = findViewById(R.id.modalFinish);

        findViewById(R.id.modalClose).setOnClickListener(v -> closeModal());
        modalOverlay.setOnClickListener(v -> {
        });
        modalPrev.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                renderSlide();
            }
        });
        modalNext.setOnClickListener(v -> {
            if (currentIndex < currentSlides.size() - 1) {
                currentIndex++;
                renderSlide();
            }
        });
        modalFinish.setOnClickListener(v -> closeModal());
    }

    private void setupCardActions() {
        findViewById(R.id.cardFood).setOnClickListener(v -> openModal(foodSlides()));
        findViewById(R.id.cardAid).setOnClickListener(v -> openModal(firstAidSlides()));
        findViewById(R.id.cardGuide).setOnClickListener(v -> openModal(guideSlides()));
        findViewById(R.id.cardQuake).setOnClickListener(v -> openModal(quakeSlides()));
    }

    private void openModal(List<LibrarySlide> slides) {
        currentSlides = slides;
        currentIndex = 0;
        modalOverlay.setVisibility(View.VISIBLE);
        renderSlide();
    }

    private void closeModal() {
        modalOverlay.setVisibility(View.GONE);
    }

    private void renderSlide() {
        if (currentSlides.isEmpty()) {
            closeModal();
            return;
        }

        LibrarySlide slide = currentSlides.get(currentIndex);
        modalTitle.setText(slide.title);

        if (slide.paragraph.isEmpty()) {
            modalParagraph.setVisibility(View.GONE);
        } else {
            modalParagraph.setVisibility(View.VISIBLE);
            modalParagraph.setText(slide.paragraph);
            modalParagraph.setTextAlignment(slide.centerParagraph ? View.TEXT_ALIGNMENT_CENTER : View.TEXT_ALIGNMENT_VIEW_START);
        }

        if (slide.heroVisible) {
            modalHeroImage.setVisibility(View.VISIBLE);
            modalHeroImage.setImageResource(slide.heroIcon);
        } else {
            modalHeroImage.setVisibility(View.GONE);
        }

        bindItemRow(modalItemRow1, modalItemTitle1, modalItemDesc1, modalItemImg1, slide.item1Title, slide.item1Desc, slide.item1Icon);
        bindItemRow(modalItemRow2, modalItemTitle2, modalItemDesc2, modalItemImg2, slide.item2Title, slide.item2Desc, slide.item2Icon);

        modalPrev.setVisibility(currentIndex == 0 ? View.INVISIBLE : View.VISIBLE);
        if (currentIndex == currentSlides.size() - 1) {
            modalNext.setVisibility(View.GONE);
            modalFinish.setVisibility(View.VISIBLE);
        } else {
            modalNext.setVisibility(View.VISIBLE);
            modalFinish.setVisibility(View.GONE);
        }

        modalDots.removeAllViews();
        for (int i = 0; i < currentSlides.size(); i++) {
            TextView dot = new TextView(this);
            dot.setText(i == currentIndex ? "●" : "•");
            dot.setTextSize(18);
            dot.setTextColor(getColor(i == currentIndex ? R.color.rds_green : android.R.color.darker_gray));
            modalDots.addView(dot);
        }
    }

    private void bindItemRow(
            View row,
            TextView title,
            TextView desc,
            ImageView image,
            String itemTitle,
            String itemDesc,
            int iconRes
    ) {
        if (itemTitle.isEmpty() && itemDesc.isEmpty()) {
            row.setVisibility(View.GONE);
            return;
        }
        row.setVisibility(View.VISIBLE);
        title.setText(itemTitle);
        desc.setText(itemDesc);
        image.setImageResource(iconRes);
    }

    private List<LibrarySlide> foodSlides() {
        return Arrays.asList(
                new LibrarySlide(
                        "Alimentos y agua",
                        "Es clave contar con suficiente agua y alimentos, ya que en muchos terremotos el colapso de estructuras puede bloquear las salidas y dejarte atrapad@, haciendo necesario sobrevivir hasta que llegue el equipo de rescate. A continuación te dejamos una lista de lo primordial:",
                        true,
                        true,
                        android.R.drawable.ic_menu_agenda,
                        "", "", 0,
                        "", "", 0
                ),
                new LibrarySlide(
                        "Alimentos y agua",
                        "",
                        false,
                        false,
                        0,
                        "Abrelatas manual",
                        "Necesario para abrir los ya mencionados enlatados y evitar cortes al intentar abrirlos con las manos.",
                        android.R.drawable.ic_menu_manage,
                        "Parrilla de carbón o gas",
                        "Permite cocinar alimentos si no hay electricidad o gas en casa tras un terremoto, asegurando que puedas comer de forma segura.",
                        android.R.drawable.ic_menu_compass
                ),
                new LibrarySlide(
                        "Alimentos y agua",
                        "",
                        false,
                        false,
                        0,
                        "Alimentos no perecederos, como enlatados",
                        "Al ser enlatados, duran más y no necesitan refrigeración, así que no tendrás que preocuparte porque se echen a perder.",
                        android.R.drawable.ic_menu_sort_by_size,
                        "Agua en botellas",
                        "Es esencial porque el cuerpo necesita agua para funcionar correctamente, y la deshidratación puede afectar tu energía, concentración y salud.",
                        android.R.drawable.ic_menu_upload
                ),
                new LibrarySlide(
                        "Alimentos y agua",
                        "En resumen, contar con estos elementos te permitirá mantenerte alimentad@, hidratad@ y segur@ en caso de quedar atrapad@ o sin servicios básicos tras un terremoto. Estar preparad@ puede marcar la diferencia mientras esperas ayuda.",
                        true,
                        true,
                        android.R.drawable.ic_menu_myplaces,
                        "", "", 0,
                        "", "", 0
                )
        );
    }

    private List<LibrarySlide> firstAidSlides() {
        return Arrays.asList(
                new LibrarySlide(
                        "Primeros auxilios",
                        "Tener un kit de primeros auxilios en un terremoto es crucial porque puedes sufrir cortes, golpes o heridas mientras esperas ayuda. Si quedas atrapad@ o los servicios médicos tardan en llegar, podrás atender lesiones básicas y evitar que empeoren.",
                        true,
                        true,
                        android.R.drawable.ic_menu_info_details,
                        "", "", 0,
                        "", "", 0
                ),
                new LibrarySlide(
                        "Primeros auxilios",
                        "",
                        false,
                        false,
                        0,
                        "Vendas, gasas, esparadrapo",
                        "Para tapar heridas y evitar una futura infección.",
                        android.R.drawable.ic_menu_edit,
                        "Mascarillas",
                        "Ya que el aire puede llenarse de polvo y escombros, te ayudarán a proteger tus vías respiratorias.",
                        android.R.drawable.ic_menu_close_clear_cancel
                ),
                new LibrarySlide(
                        "Primeros auxilios",
                        "",
                        false,
                        false,
                        0,
                        "Agua oxigenada",
                        "Para limpiar y desinfectar heridas en caso de cortes o raspaduras previniendo infecciones.",
                        android.R.drawable.ic_menu_gallery,
                        "Crema tópica",
                        "Para aliviar irritaciones, quemaduras leves o picaduras que puedan ocurrir durante un terremoto, protegiendo la piel y evitando infecciones.",
                        android.R.drawable.ic_menu_crop
                ),
                new LibrarySlide(
                        "Primeros auxilios",
                        "",
                        false,
                        false,
                        0,
                        "Analgésicos, antibióticos",
                        "Analgésicos para aliviar dolor causado por golpes o lesiones y antibióticos para combatir infecciones en heridas.",
                        android.R.drawable.ic_menu_info_details,
                        "", "", 0
                )
        );
    }

    private List<LibrarySlide> guideSlides() {
        return Arrays.asList(
                new LibrarySlide(
                        "Guía práctica sobre qué hacer en caso de emergencia",
                        "",
                        false,
                        true,
                        android.R.drawable.ic_menu_agenda,
                        "", "", 0,
                        "", "", 0
                ),
                new LibrarySlide(
                        "Guía práctica sobre qué hacer en caso de emergencia",
                        "",
                        false,
                        false,
                        0,
                        "Mantén la calma",
                        "Evitando el pánico o histeria colectiva y trata de ubicarte en lugares seguros, lejos de cosas que puedan caer y golpearte.",
                        android.R.drawable.ic_menu_help,
                        "Desarrolla un plan de emergencias",
                        "Para protección, seguridad y evacuación en caso que ocurra una emergencia todos los miembros de tu hogar sepan qué hacer.",
                        android.R.drawable.ic_menu_edit
                )
        );
    }

    private List<LibrarySlide> quakeSlides() {
        return Arrays.asList(
                new LibrarySlide(
                        "Sabías que...",
                        "Los sismos se categorizan en una escala llamada \"La escala de Richter\" dependiendo de su magnitud o gravedad de la siguiente manera:",
                        true,
                        true,
                        android.R.drawable.ic_menu_mapmode,
                        "", "", 0,
                        "", "", 0
                ),
                new LibrarySlide(
                        "Sabías que...",
                        "",
                        false,
                        false,
                        0,
                        "No sensible",
                        "Sentido por muy pocas personas en reposo, en viviendas.",
                        android.R.drawable.ic_menu_help,
                        "Sentido levemente",
                        "Sentido solamente por muy pocas personas en reposo, en viviendas.",
                        android.R.drawable.ic_menu_mapmode
                ),
                new LibrarySlide(
                        "Sabías que...",
                        "",
                        false,
                        false,
                        0,
                        "Débil",
                        "Sentido por pocas personas en el interior de viviendas. Las personas en reposo sienten una oscilación o temblor leve.",
                        android.R.drawable.ic_menu_directions,
                        "Observado ampliamente",
                        "Sentido por muchas personas en el interior de edificaciones y por pocas en el exterior. Las ventanas, puertas y platos vibran.",
                        android.R.drawable.ic_menu_gallery
                ),
                new LibrarySlide(
                        "Sabías que...",
                        "",
                        false,
                        false,
                        0,
                        "Fuerte",
                        "Sentido por casi todos en el interior de edificaciones y por pocos fuera. Muchas personas se despiertan.",
                        android.R.drawable.ic_menu_compass,
                        "Causa daños leves",
                        "Muchas personas se asustan y corren al calle. Algunas pierden el equilibrio.",
                        android.R.drawable.ic_menu_crop
                ),
                new LibrarySlide(
                        "Sabías que...",
                        "",
                        false,
                        false,
                        0,
                        "Causa daños",
                        "La mayoría de las personas se asusta y corre al exterior. Muchos edificios bien construidos sufren daños moderados.",
                        android.R.drawable.ic_menu_slideshow,
                        "Causa daños severos",
                        "A muchas personas les cuesta mantenerse de pie y se pueden desplazar o volcar muebles pesados.",
                        android.R.drawable.ic_menu_delete
                ),
                new LibrarySlide(
                        "Sabías que...",
                        "",
                        false,
                        false,
                        0,
                        "Destructivo",
                        "Pánico general, muchas construcciones débiles colapsan. Incluso edificios construidos muestran daños.",
                        android.R.drawable.ic_menu_manage,
                        "Muy destructivo",
                        "Muchos edificios bien construidos colapsan.",
                        android.R.drawable.ic_menu_revert
                ),
                new LibrarySlide(
                        "Sabías que...",
                        "",
                        false,
                        false,
                        0,
                        "Devastador",
                        "La mayoría de los edificios bien construidos colapsan, incluso algunos con buen diseño sismorresistente son destruidos.",
                        android.R.drawable.ic_menu_directions,
                        "Completamente devastador",
                        "Casi todos los edificios son destruidos.",
                        android.R.drawable.ic_menu_mylocation
                )
        );
    }

    private static class LibrarySlide {
        final String title;
        final String paragraph;
        final boolean centerParagraph;
        final boolean heroVisible;
        final int heroIcon;
        final String item1Title;
        final String item1Desc;
        final int item1Icon;
        final String item2Title;
        final String item2Desc;
        final int item2Icon;

        LibrarySlide(
                String title,
                String paragraph,
                boolean centerParagraph,
                boolean heroVisible,
                int heroIcon,
                String item1Title,
                String item1Desc,
                int item1Icon,
                String item2Title,
                String item2Desc,
                int item2Icon
        ) {
            this.title = title;
            this.paragraph = paragraph;
            this.centerParagraph = centerParagraph;
            this.heroVisible = heroVisible;
            this.heroIcon = heroIcon;
            this.item1Title = item1Title;
            this.item1Desc = item1Desc;
            this.item1Icon = item1Icon;
            this.item2Title = item2Title;
            this.item2Desc = item2Desc;
            this.item2Icon = item2Icon;
        }
    }
}
