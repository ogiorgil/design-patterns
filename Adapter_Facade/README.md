# Problem Description


Part 1 - [Linguamorphism for Ancient Grimoires](#linguamorphism-for-ancient-grimoires)

Part 2 - [Logistix Department and The Cave of Abundance](#logistix-and-the-cave-of-abundance)

## Linguamorphism for Ancient Grimoires

Serombongan Explorer memasukki gedung Omegaware Ltd. saat kamu membeli dosis kafein harianmu pagi ini. Mereka membawa
peti-peti besar yang terlihat sepuh dan dekil. Diiringi pandangan ingin tahu dari karyawan lain, rombongan Explorer itu
membawa jarahan mereka ke Witchcraft Research Department untuk diteliti.

Pemandangan ini terjadi setidaknya dua minggu sekali di kantormu. Omegaware Ltd. memberangkatkan sekelompok Explorer ke
dungeon-dungeon di seluruh negeri untuk mendapatkan barang-barang magis. Hingga kini, kamu tidak yakin bagaimana
perusahaan ini mendapatkan keuntungannya, tapi entah bagaimana mereka selalu membayar karyawan-karyawannya dengan baik.

Katanya, bayaran para Explorer adalah yang paling tinggi di antara yang lain. Kamu menganggap fakta ini cukup adil,
berhubung mereka berhadapan dengan monster dan gua yang dipenuhi perangkap kuno. Kamu, tentu saja bukan seorang
Explorer. Ha! Hal paling mengerikan yang pernah kamu *explore* adalah dokumentasi Spring Boot, bagaimana kamu mau
menghadapi monster? Meski begitu, kamu ini seorang Technological Wizard yang dianggap jago oleh teman-teman
departemenmu. Katanya, tidak ada yang menandingi kemampuanmu sejak kamu muncul tiba-tiba dua tahun yang lalu.

Kamu tidak mendengar apa-apa lagi tentang jarahan para Explorer sepanjang hari itu–sampai seorang Witchcraft Analyst
bernama Nuule memasuki ruanganmu saat jam kerja hampir habis. Kamu berkomat-kamit pura-pura sibuk supaya Nuule tidak
menghampiri kubikelmu.

Berhasil! Nuule ternyata berhenti di kubikel Buulyen, serorang Elf darah campuran yang duduk di seberangmu.

"Kau sudah dengar tentang para Explorer yang baru pulang?" tanya Nuule, secara praktis duduk di meja kubikel Buulyen dan
membelakangimu. Ia membawa semacam bundelan kertas tipis yang sudutnya sudah terlipat dan sobek-sobek. Kamu melihat
Buulyen mengangguk. "Bagus kalau begitu, ini akan cepat," lanjut Nuule sebelum mengambil napas panjang.

"Mereka menemukan setumpuk peti berisi Grimoire–" Nuule memulai. Grimoire adalah buku sihir yang seringnya berisi
mantra-mantra atau instruksi untuk membuat benda magis. "–dalam `Lingua Aeron`."

Buulyen berkedip dua kali, tanpa sadar kamu mengikutinya dan melakukan hal yang sama. Lingua Aeron adalah bahasa yang
digunakan oleh peradaban kuno Aeron beberapa milenia yang lalu. Kini, tak ada yang menggunakan maupun mengingatnya
lagi. (Legenda mengatakan kalau orang-orang Aeron dulunya adalah pengrajin takhta.)

"Kami perlu kamu membuatkan alat bantu untuk menterjemahkan tumpukan Grimoire itu." Nuule sekarang berbicara cepat
sehingga Buulyen tidak punya kesempatan untuk memotongnya. "Ini–" Nuule menyodorkan bundelan kertas yang dibawanya, "
adalah buku panduan translasi yang selalu kami gunakan. Semua ada di dalam situ."

Nuule bangkit. "Kami membutuhkan alatnya di hari Senin. Bisa kan? Bisa, ya. Kamu kan hebat." Nuule tertawa, mengacak
rambut Buulyen dengan mengesalkan, dan melenggang keluar ruangan.

Rusa keramat! Tapi ini kan hari Jumat!

Buulyen menangkap pandanganmu. "Kau mendengar semuanya kan?" tanyanya.

Khawatir dengan respon apapun yang akan kamu berikan, kamu hanya bisa mengangguk samar dan berharap Buulyen
mengartikannya sebagai tidak.

"Oh syukurlah. Dengar, bibinya sepupuku akan menikah besok lusa dan kami harus menyiapkan segalanya. Kau tahu aku darah
campuran, kan? Kalau aku tidak membantu, bisa-bisa aku semakin dikucilkan keluarga! Aku tidak mungkin lembur!" Buulyen
berbicara cepat seperti saat Nuule berusaha mencegahnya untuk memotong. "Gantikan aku, ya? Ya? Ya? Ya?"

Kalian bertatapan lama sekali selagi kamu menyusun kata-kata untuk menolaknya dengan tegas dan bergaya. Sayangnya, dia
mendahuluimu.

"Nanti kubelikan Toffee Caramel Pudding Boba," tambah Buulyen. Kamu menelan ludah. "Dua lusin."

"*Deal*."

SIAL. Apa yang baru saja kamu katakan? Buulyen melempar buku panduan tadi ke arahmu dan bergegas meninggalkan ruangan
untuk menikmati akhir pekannya. Sementara itu, kamu terjebak dalam kubikel ini untuk beberapa jam kedepan (dengan
perkiraan optimis) atau semalaman (dengan perkiraan realistis).

Setelah cukup lama berkutat dengan buku panduan itu, kamu akhirnya memulai proses translasinya. Sebuah kalimat dalam
Lingua Aeron terdiri dari beberapa kata, di mana setiap kata dipisahkan dengan karakter `0`. Kamu berpikir untuk
menggunakan alat `LinguaTranslator` yang disediakan departemen untuk mengubah setiap kata pada kalimat
menjadi `Lingua Latin` (Bahasa manusia) secara terpisah. Akan tetapi, tentu saja pekerjaan ini tidak sesederhana yang
kamu bayangkan. Baru sekali melakukan percobaan translasi, kamu sudah menemukan sebuah keanehan. Kamu mencoba
menerjemahkan kata `SCHZM` dengan `LinguaTranslator`. Kata tersebut seharusnya berarti `magic`, tapi hasil yang kamu
dapat malah `vpznt`.

Setelah melanjutkan penelitian, rupanya proses translasinya melibatkan lebih dari satu langkah. Sebelum kata diubah
dengan `LinguaTranslator`, ada transformasi khusus yang perlu dilakukan. Kamu menuangkan transformasi pertama ke sebuah
alat bernama `Cipher`. Transformasi ini dilakukan dengan memasukkan kata yang disertai setting `decode`. Sebagai contoh,
memasukkan `SCHZM` dengan setting `decode` akan menghasilkan `nLdJv`, sementara memasukkan `nLdJv` dengan
setting `encode` akan menghasilkan `SCHZM`.

Selanjutnya, posisi dari setiap huruf dalam kata ini digeser sebanyak 3 posisi ke kanan, jadi dari `nLdJv`
menjadi `dJvnL`. Perhatikan bahwa huruf yang di ujung kanan akan digeser ke posisi awal. Kamu telah membuat alat kedua
bernama `Shifter` yang dapat menggeser-geser posisi seberapapun yang dibutuhkan. Barulah setelah mengecek ulang, kamu
mendapati bahwa `dJvnL` berhasil ditranslasikan menjadi `magic` dengan `LinguaTranslator` yang kamu rancang.

Kamu akhirnya berhasil mendapatkan rancangan sebuah alat terjemahan lengkap. Alat ini menerima masukan sebuah kalimat
dalam `Lingua Aeron` dan akan menerjemahkannya menjadi `Lingua Latin` dengan memanfaatkan bantuan alat-alat yang telah
dibuat. Alat rancanganmu juga harus dapat menerjemahkan secara terbalik dari `Lingua Latin` menjadi `Lingua Aeron`.
Sebagai contoh, memasukkan `=ib0%ZCS_0SCHZM`akan menghasilkan `aku cinta magic` , dan memasukkan `aku cinta magic` akan
menghasilkan `=ib0%ZCS_0SCHZM`.

Masalah translasi ini melibatkan proses yang rumit (mengingat keberadaan buku panduan yang hampir sobek di tanganmu),
meski setelah dipikirkan baik-baik sebenarnya cukup sederhana. Witchcraft Research Department hanya membutuhkan alat
yang bisa menerjemahkan Lingua Aeron ke Lingua Latin dan sebaliknya.

Karena tidak berniat menghabiskan akhir pekanmu dengan lembur, kamu segera mengerjakan alat penerjemah permintaan Nuule.

### Hint

Baca dan pahami setiap `tools` yang disediakan. Lihat juga tests nya untuk memahami cara memakai tools bersangkutan.

### Tasks

- [ ] Membaca dokumen dan memahami deskripsi dan ekspektasi yang diminta soal
- [ ] Menerapkan design pattern yang tepat untuk membuat alat translator
- [ ] Membuat test cases untuk setiap method yang dilengkapi / dibuat

## Logistix Department and The Cave of Abundance

Nuule kembali ke kubikelnya setelah meminta bantuan orang Department of Technological Wizardry. Ia membuka lagi tumpukan
Grimoire di mejanya satu per satu. Semuanya usang dan rapuh, dan tidak satupun yang bisa dia baca. Nuule menutup
Grimoire satu dan membuka yang lainnya.

Salah satu Grimoire itu memiliki halaman yang terlipat. Nuule membuka lipatan di halaman itu dan menemukan gambar peta
tua dan beberapa baris tulisan yang bisa ia baca sebagian. Ia mengenalinya sebagai Lingua Latin, tetapi hurufnya
menggunakan huruf kuno. Nuule baru saja menemukan peta menuju Dungeon of Abundance.

Menurut legenda, Dungeon of Abundance penuh dengan harta karun dan barang jarahan yang bisa diklaim oleh siapa saja,
tapi tidak pernah ada yang berhasil menemukannya. Bersemangat karena temuan ini, Nuule melaporkan hal tersebut kepada
atasannya.

Perusahaan langsung bergerak setelah menemukan peta itu. Semua Explorer yang baru pulang akan langsung diberangkatkan
lagi di hari Senin. Omegaware Ltd. juga memutuskan untuk membentuk divisi baru di bidang logistik untuk membawa pulang
jarahan para Explorer supaya mereka bisa fokus mengeksplorasi Dungeon of Abundance.

Namun, merekrut karyawan baru akan memakan biaya dan waktu yang lama. Para pejabat Omegaware Ltd. memutuskan untuk
mengisi divisi baru ini secara instan dengan automata `Droid`. Perusahaan membutuhkan `Droid` yang bisa melakukan
pekerjaan berat, seperti mengangkat barang, menghitung barang, mengirim barang dengan transporter, dan menggunakan
crane.

Beberapa *batch* pesanan `Droid` sudah dibuat. Akan tetapi, para Analyst menemukan bahwa `Droid` tidak *cost-effective*
dan bisa membuat perusahaan merugi bila keseluruhan divisi baru itu hanya berisi `Droid`. Akhirnya, perusahaan beralih
ke automata jenis lain, yaitu `Golem` dan makhluk `Fluid` yang lebih murah.

Pesanan `Golem` dan `Fluid` telah dibuat juga, tetapi terjadi miskomunikasi dalam prosesnya. Rupanya pesanan automata
itu dibentuk oleh sihir kuno dari Negeri Asnax. Karena sihirnya kuno, para `Golem` dan makhluk `Fluid` tersebut tidak
bisa mengoperasikan peralatan modern seperti crane dan transporter. Perusahaan akan kembali merugi kalau automata yang
sudah dipesan ini tidak segera diperbaiki. Pasalnya, automata yang telah dipesan tidak bisa mengerjakan satupun
pekerjaan yang dibutuhkan perusahaan.

Karena dikira sudah familiar dengan translasi sihir kuno, Nuule merekomendasikan kamu untuk menjadi penanggung jawab
proyek ini. Kamu diminta perusahaan untuk mengakali `Golem` dan `Fluid` yang sudah dipesan supaya bisa melakukan semua
pekerjaan yang bisa dikerjakan sebuah `Droid`.

Setelah menyerahkan translator buatanmu pada Nuule, kamu menarik napas berat dan kembali untuk mulai mengerjakan proyek
baru ini. Sebuah `Droid`, `Golem` dan makhluk `Fluid` telah berbaris manis di samping kubikelmu ketika kamu tiba. Kamu
meneliti mereka satu per satu berikut dokumen *requirement* yang diminta perusahaan.

Sebuah Automata harus dapat melakukan action sebagai berikut:

1. Mengangkat barang
2. Menghitung barang
3. Menggunakan Crane
4. Mengirim barang menggunakan Transporter

Sebuah `Droid` bisa melakukan empat macam aksi, yaitu:

1. `liftItem(item)`
2. `countItem(inventory, item)`
3. `useTransporter()`
4. `useCrane()`

Sebuah `Golem` bisa melakukan melakukan empat macam aksi, yaitu:

1. `liftItem(item)`: Mengangkat `item`
2. `isItem(item1, item2)`: Memberi tahu apakah `item1` sama dengan `item2`
3. `punch(item)`: Memukul `item`
4. `toss(item)`: Melempar `item`

Kamu pikir kamu bisa memanfaatkan kemampuan `Golem` secara kreatif. Crane bisa digunakan jika *lever* nya ditekan,
jadi `Golem` bisa menonjok *lever* itu untuk menjalankan crane. Untuk menghitung barang, kamu akan meminta golem untuk
membedakan setiap barang dalam inventori satu per satu untuk kemudian mencatat hasilnya. Terakhir, lemparan `Golem`
sangat kuat dan akurat sehingga dia bisa melemparkan barang hingga ke tujuan tanpa bantuan transporter (kamu mengetahui
hal ini setelah menyuruhnya melempar beberapa barang aneh ke kubikel Buulyen–seperti gumpalan kertas dan sampah ringan
di sekitar meja kerjamu).

Sebuah `Fluid` bisa melakukan empat empat macam aksi, yaitu:

1. `pushItem(item, direction)`: Mendorong `item` ke arah `direction`
2. `splitBy(inventory, item)`: Membelah diri setiap kali ia melihat `item` pada `inventory`
3. `merge()`: Menggabungkan kembali fluid yang telah membelah diri menjadi satu
4. `shapeShift(shape)`: Menjelma diri menjadi `shape`

`Fluid` tidak bisa melakukan satupun dari aksi yang diharuskan. Solusi untuk mengakali yang ini lebih rumit. Kamu
pikir, `Fluid` bisa mengangkat sebuah barang dengan cara mendorongnya ke atas, efeknya akan sama. Sebuah `Fluid` pada
dasarnya tidak bisa berhitung, tetapi ia tahu berapa kali ia telah membelah diri. Kamu tidak perlu menghitung
belahan `Fluid` secara manual karena ia akan memberitahumu berapa kali ia telah membelah diri dalam bilangan binary.
Kamu ragu orang-orang di Witchcraft Research Department mengetahui apa-apa tentang binary, jadi kamu harus melakukan
sesuatu tentang itu. Selain itu, `Fluid` tidak bisa mengoperasikan crane maupun transporter, tetapi dia bisa menjelma
jadi peralatan yang pernah dilihatnya dan menangani barang sebagai peralatan yang ditirunya. Terakhir, kamu menemukan
bahwa `Fluid` tidak bisa melakukan pekerjaan lain dalam bentuk sudah terbelah sehingga perlu menyatukan diri seperti
semula sebelum mengerjakan aksi selanjutnya.

Selesai melakukan pengamatan pada automata di kubikelmu, kamu bersyukur kamu bukan seorang Overseer yang akan mengawasi
para automata ini di lapangan. Terutama dengan banyaknya barang yang harus ditangani di Dungeon of Abundance, Overseer
yang kebagian nasib buruk itu pasti akan pegal linu. Kamu berpikir untuk melakukan tindakan preventif dengan memastikan
semua aktivitas automata tercatat dengan baik. Ini akan menyelamatkanmu dari kerja lembur lainnya jika Nuule mendapatkan
keluhan apapun dari para pekerja lapangan.

Kamu kemudian menggulung lengan baju dan meregangkan tangan, bersiap untuk bekerja. Salah satu design pattern yang kamu
pelajari terbersit di pikiranmu karena cocok sekali diterapkan untuk proyek ini. Kamu mulai menerapkan pattern tersebut
untuk mencegah perusahaan merugi.