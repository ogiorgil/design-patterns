# MVC Pattern and REST API

## Problem Description

Anda perlahan membuka mata anda. Jam dinding memperlihatkan pukul 1 kurang 15 menit. Anda tidak mengingat apa yang
terjadi dalam beberapa menit terakhir. Lalu anda merasakan seseorang sedang menusuk pipi anda dengan telunjuknya.

"Cepat bangun dan ikut aku." Emory seperti biasa berkomentar dengan cukup dingin. Tanpa memberikan penjelasan lebih
lanjut ia pergi begitu saja dan membuat anda harus setengah berlari untuk mengejarnya.

"Ada klien dari Frostwatch. " ujar Emory yang lalu diam, membuat anda terus berharap ada kelanjutan dari pernyataan
tersebut.Tapi ini adalah Emory yang kita bicarakan. Sangat aneh jika ia memberikan penjelasan lebih lanjut tanpa
ditanya.

Frostwatch adalah sebuah kota beriklim dingin di pusat Tidaholm, sebuah benua utara. Kota terletak cukup strategis tapi
dari apa yang anda dengar cukup tertinggal mengenai teknologi. Mendengar bahwa ada seseorang dari Frostwatch ingin
membuat aplikasi tidak pernah terpintas di pikiran anda.

Diskusi antara perusahaan anda dengan delegasi sebuah perusahaan di Frostwatch berlangsung cukup lancar, tapi penuh
dengan pembiaraan yang membuat bulu kuduk anda merinding. Ini kali pertama anda berbicara dengan seseorang dari benua
utara dan dalam 20 menit diskusi anda langsung berharap tidak bertemu dengan mereka lagi.

"Jadi begitu ide aplikasi yang kami harapkan. Pada dasarnya kami ingin sebuah situs portal berita. Kami merasa
orang-orang di Frostwatch masih kurang mendapatkan akses ke informasi. Jadi dengan situs ini kami berharap akses
terhadap isu-isu terkini lebih mudah didapatkan. Sumber beritanya didapatkan dari berbagai pengunjung Frostwatch.
Penulisnya sendiri kami berencana akan membuka lowongan melalui oprec. Nanti kami akan membuatkan akun untuk
penulis-penulis agar mereka dapat mengolah artikel-artikel mereka sendiri. "

Delegasi itu terus menjelaskan harapan aplikasi yang mereka inginkan. Ia membahas bagaimana setiap artikel akan memiliki
kategori tertentu. Sejauh ini tidak ada yang aneh dari diskusi yang sedang anda lakukan. Delegasi juga menjelaskan untuk
prototipe awal sistem mereka hanya mengharapkan sistem yang simpel terlebih dahulu. Tidak perlu sistem autentikasi untuk
sistem awal ini, tapi masih perlu ada informasi mengenai siapa penulis artikel sebagai salah satu field pada basis data
sistem ini. Ini dapat dilakukan dengan mudah dengan menambahkan id penulis sebagai salah satu *field* JSON request. Anda
juga sudah membayangkan apa saja yang perlu ada dalam sebuah artikel. Sebuah artikel berisikan judul, isi, waktu artikel
tersebut dibuat dan waktu di-update. Hingga saat ini hanya ada pembahasan *requirement* biasa dari klien anda. Tapi,
pembahasan selanjutnya yang menjadi masalah.

"Kami juga ingin kategori ini sespesifik mungkin." Salah satu delegasi yang lain memotong pembicaraan. Wajah delegasi
yang dipotong memperlihatkan ketidaksukaan. Namun, ia seperti mencoba bersabar dan membiarkan delegasi lain tersebut
berbicara.

"Misalkan kita bisa saja memiliki kategori khusus seperti 'perang dunia', 'perang Gothia Raya', dan 'perang
nuklir'.Lalu--"

"Tunggu Rico, ini bukan yang kita bicarakan sebelumnya. " Delegasi yang sepertinya merupakan juru bicara Frostwatch
memotong balik delagasi yang sepertinya bernama Rico tadi. "Aku rasa kategori 'perang' cukup untuk menjelaskan semua hal
tersebut."

"Tidak, itu akan menjadi tidak menarik Franco." Desis Rico balik. "Jika kita kategorikan sebagai 'perang' saja nanti
bisa saja ada kategori seperti 'perang cinta', 'perang ambassador' dan aku rasa itu tidak akan baik. Orang-orang akan
merasa kesal dengan model aplikasi seperti itu karena tidak bisa menemukan kategori yang mereka inginkan dengan cepat. "

"Bukannya itu juga menyulitkan pengguna bukan?" Franco mempercepat tempo bicaranya. Rico hanya memangut kesal karena
tidak bisa memotong Franco. Franco lalu melanjutkan: "Akan terlalu banyak kategori, sehingga navigasi akan menjadi
sulit.

"Bagaimana kalau ada sebuah artikel yang dapat masuk ke lebih dari satu kategori? Saya merasa benda seperti smartphone
dapat masuk ke kategori teknologi dan lifestyle. Akan lebih masuk akal kalau kategorinya spesifik. Kita tidak perlu
memikirkan kemungkinan ini! Kalau kita buat kategori terlalu umum, terlalu banyak kemungkinan pada kasus artikel semacam
ini."

Franco semakin terlihat kesal. Keduanya lalu terus melanjutkan perdebatan mereka. Anda juga bingung bagaimana mulai
memisahkan mereka. Pada akhirnya, anda harus mendengarkan apa yang klien inginkan. Namun, bagaimana anda bisa melakukan
itu dengan klien sendiri tidak memiliki opini yang konsisten.

"Bagaimana apabila artikel dapat bisa masuk ke lebih dari satu kategori." Emory memotong pekelahian mereka. Keduanya
lalu menatap balik ke Emory. "Jadi smartphone dapat masuk ke kedua kategori seperti yang anda katakan."

Keduanya masih menatap bingung. Anda lalu menyadari bahwa memang mereka berasal dari Frostwatch. Mungkin di kepala
mereka pengkategorian pada aplikasi layaknya menyimpan berkas artikel secara fisik pada folder tertentu. Jika
dianalogikan seperti itu, solusi Emory tadi dan kekhawatiran Rico masuk akal. Tapi hal yang seperti ini tidak berlaku
pada aplikasi dengan sistem basis data relational.

"Hal ini dapat kami implementasikan.Tenang saja, desain ini memungkinkan." tambah anda.

Wajah mereka terlihat lebih melunak, tapi masalah mereka tentu saja belum selesai. Ide Emory memang dapat menyelesaikan
kemungkinan ada artikel yang masuk ke lebih dari satu kategori, tapi masalah preferensi yang dari tadi mereka bahas
tidak akan selesai dengan solusi tersebut. Tapi, Anda menemukan ide untuk menyelesaikan masalah tersebut.

"Untuk kategori bagaimana jika kita buat ada pembedaan kategori? Jadi ada kategori umum dan kategori-kategori spesifik
yang termasuk kategori dalamnya. Kategori-kategori spesifik ini kemudian dijadikan sebuah kelompok. Sebagai contoh, kita
bisa membuat kategori umum 'perang', dan di dalamnya ada kategori-kategori yang lebih spesifik seperti 'perang dunia', '
perang gothia raya', dll. Jadi ada dua level dalam pengkategorian sebuah artikel."

Keduanya lalu mundur. Sepertinya solusi itu cukup untuk memuaskan mereka. Rapat lalu berakhir dengan tenang. Sekarang
anda tinggal memulai pengembangan.

"Aku serahkan frontend padamu ya."

"Serahkan pada kami." Maya, team lead divisi frontend hanya membalas lirih sebelum akhirnya kembali ke ruangan mereka.
Emory lalu menepuk pundak anda.

"Inilah kenapa aku membawamu. Aku yakin kau sudah pernah melihat hal serupa dari 'seberang sana'. Selanjutnya aku ingin
kamu membantuku menyelesaikan aplikasi ini."

"Dengan senang hati."

Anda lalu juga kembali ke ruangan bersama Emory untuk memulai pekerjaan. Saat anda akan masuk kembali ke ruangan anda,
anda merasakan hawa kehadiran seseorang dari belakang anda. Namun, ketika melihat ke belakang, anda tidak mendapati
siapa-siapa. Anda kemudian mencoba tidak mempedulikannya sekarang dan kembali berjalan ke ruangan kerja anda.

"Kita akan bertemu lagi.." Gadis itu terkekeh lalu menghilang dari balik kegelapan.

## Penjelasan Kode

Pada tutorial ini deliverablenya tidak berbentuk website, melainkan hanya
sebuah [REST API](https://www.redhat.com/en/topics/api/what-is-a-rest-api). Secara sederhana, setiap *endpoint*
mengeluarkan [JSON](https://www.json.org/json-en.html). Dalam mengerjakan tutorial, ada dua konsep baru yang perlu
diketahui, yaitu **REST Controller** dan **JPA Repository**. Selain itu, ada **Postman** untuk membantu menguji
aplikasi, dan mekanisme **Code Coverage**

### Rest Controller

```
@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getCategory(@PathVariable(value = "id") int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }
}
```

Kita lihat di sini ada `@RestController`, sebuah anotasi untuk memungkinkan kapabilitas controller untuk melakukan
operasi-operasi REST. Kedua method `postCategory` dan `getCategory` menerima dan mengembalikan sebuah JSON. Pada
request, ada yang disebut [status code](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes).
Method `ResponseEntity.ok()` mengembalikan JSON dengan status `200` (OK), dan `ResponseEntity(HttpStatus.NOT_FOUND)`
mengembalikan dengan status `404`

### JPA Repository

Berbeda dengan tutorial-tutorial sebelumnya yang menggunakan tempat penyimpanan simulasi, pada tutorial ini kita
mempelajari cara menggunakan database
sungguhan. [JPA Repository](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa) merupakan sebuah *
Object-relational Mapping* (ORM) pada spring untuk berinteraksi dengan database.

```
@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "num_articles")
    private int numArticles;

    public Category(String name, int numArticles){
        this.name = name;
        this.numArticles = numArticles;
    }

}
```

Penjelasan anotasi:

- Anotasi `Entity` dan `Table()` digunakan untuk memberi tahu bahwa class ini akan disimpan di database.
- Anotasi `@Column` memberi tahu nama kolom dari setiap atribut pada database.
- Anotasi `@GeneratedValue()` memberi tahu bahwa atribut ini akan diisi secara automatis ketika memasukkan ke database

Untuk membuat repositor sebuah `@Entity`, cukup buat bean `@Repository` yang extends `JpaRepository`

```
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);
}

```

Nantinya `CategoryRepository` sudah dapat digunakan dengan melakukan `@Autowire` ke service-service yang membutuhkan.
Concrete class dari `CategoryRepository` di mana? silahkan di eksplorasi secara singkat cara kerja `JpaRepository`
karena akan menambahkan pemahamanmu.

Konfigurasi JPA repository diatur di berkas `resources/application.properties`.

```
## default connection pool
spring.datasource.hikari.connectionTimeout=20000
spring.datasource.hikari.maximumPoolSize=5
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
# drop n create table again, good for testing, comment this in production
spring.jpa.hibernate.ddl-auto=create
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
server.error.whitelabel.enabled=false
server.error.path=/error-spring
```

Atribut `sprint.datasource` mengatur jenis (PostgreSQL, MongoDB, H2) dan credentials (username, password, nama database)
dari DBMS yang digunakan, sedangkan `spring.jpa` mengatur setting khusus JPA. Tutorial ini akan menggunakan database **
H2**, sebuah database *in-memory* sederhana untuk tujuan pembelajaran.
Konfigurasi `spring.jpa.hibernate.ddl-auto=create` akan mereset ulang database setiap aplikasi dijalankan. Silahkan
melakukan eksplorasi tentang ini jika tertarik, namun pada tutorial 5 anda belum perlu mengubah `application.properties`.