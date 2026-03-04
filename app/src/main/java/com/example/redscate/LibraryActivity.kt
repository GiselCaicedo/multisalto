package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LibraryActivity : AppCompatActivity() {
    private lateinit var modalOverlay: View
    private lateinit var modalTitle: TextView
    private lateinit var modalParagraph: TextView
    private lateinit var modalHeroImage: ImageView
    private lateinit var modalItemRow1: LinearLayout
    private lateinit var modalItemTitle1: TextView
    private lateinit var modalItemDesc1: TextView
    private lateinit var modalItemImg1: ImageView
    private lateinit var modalItemRow2: LinearLayout
    private lateinit var modalItemTitle2: TextView
    private lateinit var modalItemDesc2: TextView
    private lateinit var modalItemImg2: ImageView
    private lateinit var modalDots: LinearLayout
    private lateinit var modalPrev: Button
    private lateinit var modalNext: Button
    private lateinit var modalFinish: Button

    private var currentSlides: List<LibrarySlide> = emptyList()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        findViewById<View>(R.id.homeButton).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        findViewById<View>(R.id.profileButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<View>(R.id.helpButton).setOnClickListener {
            startActivity(Intent(this, AlertHomeActivity::class.java))
        }
        findViewById<View>(R.id.bottomDocButton).setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }

        setupModalViews()
        setupCardActions()
    }

    private fun setupModalViews() {
        modalOverlay = findViewById(R.id.modalOverlay)
        modalTitle = findViewById(R.id.modalTitle)
        modalParagraph = findViewById(R.id.modalParagraph)
        modalHeroImage = findViewById(R.id.modalHeroImage)
        modalItemRow1 = findViewById(R.id.modalItemRow1)
        modalItemTitle1 = findViewById(R.id.modalItemTitle1)
        modalItemDesc1 = findViewById(R.id.modalItemDesc1)
        modalItemImg1 = findViewById(R.id.modalItemImg1)
        modalItemRow2 = findViewById(R.id.modalItemRow2)
        modalItemTitle2 = findViewById(R.id.modalItemTitle2)
        modalItemDesc2 = findViewById(R.id.modalItemDesc2)
        modalItemImg2 = findViewById(R.id.modalItemImg2)
        modalDots = findViewById(R.id.modalDots)
        modalPrev = findViewById(R.id.modalPrev)
        modalNext = findViewById(R.id.modalNext)
        modalFinish = findViewById(R.id.modalFinish)

        findViewById<View>(R.id.modalClose).setOnClickListener { closeModal() }
        modalOverlay.setOnClickListener {}
        modalPrev.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                renderSlide()
            }
        }
        modalNext.setOnClickListener {
            if (currentIndex < currentSlides.size - 1) {
                currentIndex++
                renderSlide()
            }
        }
        modalFinish.setOnClickListener { closeModal() }
    }

    private fun setupCardActions() {
        findViewById<View>(R.id.cardFood).setOnClickListener { openModal(foodSlides()) }
        findViewById<View>(R.id.cardAid).setOnClickListener { openModal(firstAidSlides()) }
        findViewById<View>(R.id.cardGuide).setOnClickListener { openModal(guideSlides()) }
        findViewById<View>(R.id.cardQuake).setOnClickListener { openModal(quakeSlides()) }
    }

    private fun openModal(slides: List<LibrarySlide>) {
        currentSlides = slides
        currentIndex = 0
        modalOverlay.visibility = View.VISIBLE
        renderSlide()
    }

    private fun closeModal() {
        modalOverlay.visibility = View.GONE
    }

    private fun renderSlide() {
        if (currentSlides.isEmpty()) {
            closeModal()
            return
        }

        val slide = currentSlides[currentIndex]
        modalTitle.text = slide.title

        if (slide.paragraph.isEmpty()) {
            modalParagraph.visibility = View.GONE
        } else {
            modalParagraph.visibility = View.VISIBLE
            modalParagraph.text = slide.paragraph
            modalParagraph.textAlignment = if (slide.centerParagraph) {
                View.TEXT_ALIGNMENT_CENTER
            } else {
                View.TEXT_ALIGNMENT_VIEW_START
            }
        }

        if (slide.heroVisible) {
            modalHeroImage.visibility = View.VISIBLE
            modalHeroImage.setImageResource(slide.heroIcon)
        } else {
            modalHeroImage.visibility = View.GONE
        }

        bindItemRow(
            modalItemRow1,
            modalItemTitle1,
            modalItemDesc1,
            modalItemImg1,
            slide.item1Title,
            slide.item1Desc,
            slide.item1Icon
        )
        bindItemRow(
            modalItemRow2,
            modalItemTitle2,
            modalItemDesc2,
            modalItemImg2,
            slide.item2Title,
            slide.item2Desc,
            slide.item2Icon
        )

        modalPrev.visibility = if (currentIndex == 0) View.INVISIBLE else View.VISIBLE
        if (currentIndex == currentSlides.size - 1) {
            modalNext.visibility = View.GONE
            modalFinish.visibility = View.VISIBLE
        } else {
            modalNext.visibility = View.VISIBLE
            modalFinish.visibility = View.GONE
        }

        modalDots.removeAllViews()
        for (i in currentSlides.indices) {
            val dot = TextView(this)
            dot.text = if (i == currentIndex) "●" else "•"
            dot.textSize = 18f
            dot.setTextColor(getColor(if (i == currentIndex) R.color.rds_green else android.R.color.darker_gray))
            modalDots.addView(dot)
        }
    }

    private fun bindItemRow(
        row: View,
        title: TextView,
        desc: TextView,
        image: ImageView,
        itemTitle: String,
        itemDesc: String,
        iconRes: Int
    ) {
        if (itemTitle.isEmpty() && itemDesc.isEmpty()) {
            row.visibility = View.GONE
            return
        }
        row.visibility = View.VISIBLE
        title.text = itemTitle
        desc.text = itemDesc
        image.setImageResource(iconRes)
    }

    private fun foodSlides(): List<LibrarySlide> {
        return listOf(
            LibrarySlide(
                "Alimentos y agua",
                "Es clave contar con suficiente agua y alimentos, ya que en muchos terremotos el colapso de estructuras puede bloquear las salidas y dejarte atrapad@, haciendo necesario sobrevivir hasta que llegue el equipo de rescate. A continuación te dejamos una lista de lo primordial:",
                centerParagraph = true,
                heroVisible = true,
                heroIcon = android.R.drawable.ic_menu_agenda,
                item1Title = "",
                item1Desc = "",
                item1Icon = 0,
                item2Title = "",
                item2Desc = "",
                item2Icon = 0
            ),
            LibrarySlide(
                "Alimentos y agua",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Abrelatas manual",
                item1Desc = "Necesario para abrir los ya mencionados enlatados y evitar cortes al intentar abrirlos con las manos.",
                item1Icon = android.R.drawable.ic_menu_manage,
                item2Title = "Parrilla de carbón o gas",
                item2Desc = "Permite cocinar alimentos si no hay electricidad o gas en casa tras un terremoto, asegurando que puedas comer de forma segura.",
                item2Icon = android.R.drawable.ic_menu_compass
            ),
            LibrarySlide(
                "Alimentos y agua",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Alimentos no perecederos, como enlatados",
                item1Desc = "Al ser enlatados, duran más y no necesitan refrigeración, así que no tendrás que preocuparte porque se echen a perder.",
                item1Icon = android.R.drawable.ic_menu_sort_by_size,
                item2Title = "Agua en botellas",
                item2Desc = "Es esencial porque el cuerpo necesita agua para funcionar correctamente, y la deshidratación puede afectar tu energía, concentración y salud.",
                item2Icon = android.R.drawable.ic_menu_upload
            ),
            LibrarySlide(
                "Alimentos y agua",
                "En resumen, contar con estos elementos te permitirá mantenerte alimentad@, hidratad@ y segur@ en caso de quedar atrapad@ o sin servicios básicos tras un terremoto. Estar preparad@ puede marcar la diferencia mientras esperas ayuda.",
                centerParagraph = true,
                heroVisible = true,
                heroIcon = android.R.drawable.ic_menu_myplaces,
                item1Title = "",
                item1Desc = "",
                item1Icon = 0,
                item2Title = "",
                item2Desc = "",
                item2Icon = 0
            )
        )
    }

    private fun firstAidSlides(): List<LibrarySlide> {
        return listOf(
            LibrarySlide(
                "Primeros auxilios",
                "Tener un kit de primeros auxilios en un terremoto es crucial porque puedes sufrir cortes, golpes o heridas mientras esperas ayuda. Si quedas atrapad@ o los servicios médicos tardan en llegar, podrás atender lesiones básicas y evitar que empeoren.",
                centerParagraph = true,
                heroVisible = true,
                heroIcon = android.R.drawable.ic_menu_info_details,
                item1Title = "",
                item1Desc = "",
                item1Icon = 0,
                item2Title = "",
                item2Desc = "",
                item2Icon = 0
            ),
            LibrarySlide(
                "Primeros auxilios",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Vendas, gasas, esparadrapo",
                item1Desc = "Para tapar heridas y evitar una futura infección.",
                item1Icon = android.R.drawable.ic_menu_edit,
                item2Title = "Mascarillas",
                item2Desc = "Ya que el aire puede llenarse de polvo y escombros, te ayudarán a proteger tus vías respiratorias.",
                item2Icon = android.R.drawable.ic_menu_close_clear_cancel
            ),
            LibrarySlide(
                "Primeros auxilios",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Agua oxigenada",
                item1Desc = "Para limpiar y desinfectar heridas en caso de cortes o raspaduras previniendo infecciones.",
                item1Icon = android.R.drawable.ic_menu_gallery,
                item2Title = "Crema tópica",
                item2Desc = "Para aliviar irritaciones, quemaduras leves o picaduras que puedan ocurrir durante un terremoto, protegiendo la piel y evitando infecciones.",
                item2Icon = android.R.drawable.ic_menu_crop
            ),
            LibrarySlide(
                "Primeros auxilios",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Analgésicos, antibióticos",
                item1Desc = "Analgésicos para aliviar dolor causado por golpes o lesiones y antibióticos para combatir infecciones en heridas.",
                item1Icon = android.R.drawable.ic_menu_info_details,
                item2Title = "",
                item2Desc = "",
                item2Icon = 0
            )
        )
    }

    private fun guideSlides(): List<LibrarySlide> {
        return listOf(
            LibrarySlide(
                "Guía práctica sobre qué hacer en caso de emergencia",
                "",
                centerParagraph = false,
                heroVisible = true,
                heroIcon = android.R.drawable.ic_menu_agenda,
                item1Title = "",
                item1Desc = "",
                item1Icon = 0,
                item2Title = "",
                item2Desc = "",
                item2Icon = 0
            ),
            LibrarySlide(
                "Guía práctica sobre qué hacer en caso de emergencia",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Mantén la calma",
                item1Desc = "Evitando el pánico o histeria colectiva y trata de ubicarte en lugares seguros, lejos de cosas que puedan caer y golpearte.",
                item1Icon = android.R.drawable.ic_menu_help,
                item2Title = "Desarrolla un plan de emergencias",
                item2Desc = "Para protección, seguridad y evacuación en caso que ocurra una emergencia todos los miembros de tu hogar sepan qué hacer.",
                item2Icon = android.R.drawable.ic_menu_edit
            )
        )
    }

    private fun quakeSlides(): List<LibrarySlide> {
        return listOf(
            LibrarySlide(
                "Sabías que...",
                "Los sismos se categorizan en una escala llamada \"La escala de Richter\" dependiendo de su magnitud o gravedad de la siguiente manera:",
                centerParagraph = true,
                heroVisible = true,
                heroIcon = android.R.drawable.ic_menu_mapmode,
                item1Title = "",
                item1Desc = "",
                item1Icon = 0,
                item2Title = "",
                item2Desc = "",
                item2Icon = 0
            ),
            LibrarySlide(
                "Sabías que...",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "No sensible",
                item1Desc = "Sentido por muy pocas personas en reposo, en viviendas.",
                item1Icon = android.R.drawable.ic_menu_help,
                item2Title = "Sentido levemente",
                item2Desc = "Sentido solamente por muy pocas personas en reposo, en viviendas.",
                item2Icon = android.R.drawable.ic_menu_mapmode
            ),
            LibrarySlide(
                "Sabías que...",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Débil",
                item1Desc = "Sentido por pocas personas en el interior de viviendas. Las personas en reposo sienten una oscilación o temblor leve.",
                item1Icon = android.R.drawable.ic_menu_directions,
                item2Title = "Observado ampliamente",
                item2Desc = "Sentido por muchas personas en el interior de edificaciones y por pocas en el exterior. Las ventanas, puertas y platos vibran.",
                item2Icon = android.R.drawable.ic_menu_gallery
            ),
            LibrarySlide(
                "Sabías que...",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Fuerte",
                item1Desc = "Sentido por casi todos en el interior de edificaciones y por pocos fuera. Muchas personas se despiertan.",
                item1Icon = android.R.drawable.ic_menu_compass,
                item2Title = "Causa daños leves",
                item2Desc = "Muchas personas se asustan y corren al calle. Algunas pierden el equilibrio.",
                item2Icon = android.R.drawable.ic_menu_crop
            ),
            LibrarySlide(
                "Sabías que...",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Causa daños",
                item1Desc = "La mayoría de las personas se asusta y corre al exterior. Muchos edificios bien construidos sufren daños moderados.",
                item1Icon = android.R.drawable.ic_menu_slideshow,
                item2Title = "Causa daños severos",
                item2Desc = "A muchas personas les cuesta mantenerse de pie y se pueden desplazar o volcar muebles pesados.",
                item2Icon = android.R.drawable.ic_menu_delete
            ),
            LibrarySlide(
                "Sabías que...",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Destructivo",
                item1Desc = "Pánico general, muchas construcciones débiles colapsan. Incluso edificios construidos muestran daños.",
                item1Icon = android.R.drawable.ic_menu_manage,
                item2Title = "Muy destructivo",
                item2Desc = "Muchos edificios bien construidos colapsan.",
                item2Icon = android.R.drawable.ic_menu_revert
            ),
            LibrarySlide(
                "Sabías que...",
                "",
                centerParagraph = false,
                heroVisible = false,
                heroIcon = 0,
                item1Title = "Devastador",
                item1Desc = "La mayoría de los edificios bien construidos colapsan, incluso algunos con buen diseño sismorresistente son destruidos.",
                item1Icon = android.R.drawable.ic_menu_directions,
                item2Title = "Completamente devastador",
                item2Desc = "Casi todos los edificios son destruidos.",
                item2Icon = android.R.drawable.ic_menu_mylocation
            )
        )
    }

    private data class LibrarySlide(
        val title: String,
        val paragraph: String,
        val centerParagraph: Boolean,
        val heroVisible: Boolean,
        val heroIcon: Int,
        val item1Title: String,
        val item1Desc: String,
        val item1Icon: Int,
        val item2Title: String,
        val item2Desc: String,
        val item2Icon: Int
    )
}
