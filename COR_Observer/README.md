# Ekspedisi baru (package: pricing)

## Problem Description

PT. DailyNichi adalah sebuah perusahaan besar yang bergerak di bidang informasi. Perusahaan ini bertujuan untuk memberikan update-update terkini di semua hal yang terjadi di dunia ini. Informasi yang disediakan PT DailyNichi mulai dari cuaca hari ini dan event-event yang sedang berlangsung, hingga lokasi *real-time* dari naga-naga berbahaya. Setelah proses rekruitmen yang berat, anda akhirnya diterima sebagai *Software Engineer* di PT. DailyNichi. Untuk sementara, anda akan melapor ke *direct manager* anda, Pak **Kai**.

Kai gemar sekali bermain game *waifu collector* untuk melepas penatnya hidup. Secara spesifik, Kai gemar memainkan karakter Alicia karena mekanisme yang menggunakan panah dan gerakan-gerakannya sangat unik. Saking sukanya, dia mulai mencari-cari merchandise Alicia, seperti poster, *action figure*, sticker, hingga sarung bantal. Pusat merchandise Alicia ada di kota Hoyomi. Sayangnya, kota ini jaraknya cukup jauh dari tempat tinggalnya. Perjalanan ke sana dapat membutuhkan beberapa minggu. Ditambah lagi, ada potensi serangan dari penjarah atau mahluk-mahluk buas di tengah jalan.

Suatu hari, Kai melihat teman anda si Kirigaya membawa pulang *life-size figure* Asuka. Anda bertanya:


**Kai**: "Di mana anda membeli itu?"

**Kirigaya**: "Baru datang tadi pagi via Gajah"

**Kai**: "Gajah? bukankah kota Incrad pabrik Asuka jaraknya sangat jauh?"

**Kirigaya**: "Ada perusahaan yang menawarkan jasa ekspedisi dengan gajah. Ekspedisinya dapat dikirimkan dari Incrad ke sini"

**Kai**: "Oh? berapa bayarnya? bukankah jaraknya sangat jauh dan banyak mahluk buasnya?"

**Kirigaya**: "Pembayaran cukup terjangkau. Untuk ekspedisi ini, saya membayar berdasarkan berat benda dan juga jarak yang ditempuh. Pengiriman lumayan aman karena gajahnya mengintimidasi"

Mendengar ini, Kai langsung melakukan riset di sektor ekspedisi. Sektor ekspedisi sangat vital di negara ini. Terdapat banyak perusahaan ekspedisi yang masing-masing menawarkan jasa-jasa berbeda, mulai dari jasa pengiriman ekonomis oleh Goblin, hingga jasa premium oleh burung garuda. Kai merupakan seorang karyawan di PT. DailyNichi dan kini menyarankan agar PT. DailyNichi masuk ke dalam sektor ekspedisi. Kebetulan sekali PT. DailyNichi baru mendapatkan rekrut baru **yaitu anda**. Agar jasa bisa bersaing dengan perusahaan lain, PT. DailyNichi akan menawarkan tiga tipe pengiriman berbeda, yaitu pengiriman kurir kadal, kurir kuda, dan kurir garuda. Ketiga mode pengiriman ditawarkan untuk mengakomodasi berbagai berat paket berbeda. Kurir kadal untuk berat ringan (di bawah 10 kg), kurir kuda untuk berat sedang (10 - 50 kg), dan kurir garuda untuk barang berat (di atas 50 kg). Harga yang perlu di bayar bergantung pada berat barang yang dikirim. Masing-masing tipe pengiriman memiliki harga per-kilogram yang berbeda. Semua pembayaran jasa dilakukan dalam **civil credits**, e-walletnya PT. DailyNichi.

Kai tahu bahwa pengiriman antar-kota memiliki banyak potensi bahaya. Untuk menjual jasa ekspedisi PT. DailyNichi, Kai ingin ada sistem asuransi. Tujuan sistem ini adalah sebagai "jaminan" bahwa barang-barang berharga yang di kirim akan mendapatkan kompensasi setimpal jika terjadi hal yang tidak diinginkan. Semakin mahal jenis asuransinya, semakin ketat pengawalan dari paket tersebut. Untuk saat ini, direncakan ada tiga tipe asuransi, yaitu asuransi beta untuk barang pasaran (nilai barang di bawah 1.000 civil credits), asuransi alpha untuk barang reguler (nilai barang 1.000 - 50.000 civil credits), dan barang berharga (nilai barang di atas 50.000 civil credits). Setiap asuransi mematok harga tetap, dan asuransi yang lebih tinggi mematok harga yang lebih mahal.

Product Manager (PM) memberikan anda informasi baru mengenai layanan yang akan di buat. Dia mengatakan, khusus untuk kurir Garuda, ada biaya tambahan flat sebesar 2.000 civil credits untuk menggunakan jasanya. Anda sebagai karyawan PT. DailyNichi akan mengimplementasikan jasa ekspedisi ini. Program anda menerima masukan berat dan nilai barang. Untuk setiap masukan, program mengeluarkan civil credits yang harus di bayar jika menggunakan jasa ekspedisi perusahaan.

## Penjelasan Kode

Pada `core`, tersedia sebuah interface `Asuransi` dan `Kurir`. Interface `Asuransi` memiliki dua buah method:
1.  `getName()` : mendapatkan nama dari asuransi ini
2.  `getPrice()`: mendapatkan harga dari asuransi ini (civil credits)

Interface `Kurir` memiliki dua buah method:
1. `getName()`: mendapatkan nama dari asuransi ini
2. `calculatePrice(weight)`: mendapatkan total harga yang harus di bayar untuk barang seberat `weight` jika menggunakan kurir ini.

Kode `PricingInitializer.java` menginisialisasi informasi `Asuransi` dan `Kurir` di awal jalannya program.


# Tracking Ekspedisi (package: tracking)

## Problem Description

Suatu hari, terjadi suatu diskusi menarik antara *Chief Technology Officer* (CTO) dan *General Manager* (GM) perusahaan terkait pengembangan jasa ekspedisi. Diskusi ini terjadi di ruangan tertutup.

**CTO**: "Bagaimana caranya kita mengejar kompetitor kita yang sudah mulai lebih dulu?"

**GM**: "Kita minta data riset mereka"

**CTO**: "Strategi *sneak 100* ya :)"

**GM**: "Bukan, kita 'minta' secara tidak langsung dengan mengamati mereka. Bagaimana kalau beberapa karyawan kita tugaskan untuk kerja di kompetitor?"

**CTO**: "**BONK**. Saya punya ide yang lebih bagus. Kita punya divisi lain yang monitor aktivitas-aktivitas naga berbahaya bukan?"

**GM**: "Benar, kami ada monitor pada semua naga dengan level bahaya terbesar seperti Drago, Fafnir, Kanna Kamui, dan Quetzalcoatl"

**CTO**: "Kota Trifcester dan Shunard lumayan aktif kegiatan ekspedisinya. Belakangan ini, banyak laporan bahwa Drago sedang aktif di sana. Kabarnya, banyak jasa ekspedisi yang diserang oleh naga raksasa itu"

**GM**: "Anda berpikir untuk membuka API **DragoMonitor** kami ke jasa-jasa ekspedisi di Trifcester dan Shunard?"

**CTO**: "Benar, API itu akan memberi notifikasi tentang kegiatan Drago, seperti saat dia meninggalkan atau pindah lokasi. Kami akan buka APInya agar mereka bisa menghindari Drago"

**GM**: "Kemudian diam-diam kita rekam dan pelajari gerak-gerik ekspedisi tersebut? Ide yang bagus, mari kita eksekusi"

**CTO**: "Adalah benar, panggil karyawan baru kita untuk persiapan pembukaan API ini"

Anda dipanggil oleh GM dan CTO untuk menyiapkan API baru ini. Anda sangat senang karena dapat bekerja di projek skala besar yang harus memberikan notifikasi secara *real-time*. Tipikal korporat, anda hanya diberikan garis besar permintaan aplikasinya saja. Anda belum pernah ke Trifcester maupun Shunard sehingga mulai melakukan studi mandiri. Anda memutuskan bahwa cara terbaik untuk memahami lapangan adalah untuk berangkat ke TKP dengan biaya sendiri. Diketahui bahwa ada 3 rute yang dapat ditempuh untuk bepergian dari Trifcestor ke Shunard (atau sebaliknya), yakni: melewati pegunungan **Shefburg Path**, melewati rawa **Cardham Morass**, dan melewati pantai **Vottona Edge**. API akan memberi notifikasi ke semua yang berlangganan jika Drago sedang berjaga di salah satu tempat, atau jika dia meninggalkan tempat jaganya.

*Dibuatlah press release sekaligus pre-register bahwa PT. DailyNichi akan merilis API tersebut dalam waktu dekat*


**CTO**: "Wah, banyak juga ya yang tertarik dengan API kita!"

**GM**: "Data is the new oil!"

**GM**: "Eh, ini kok perusahaan **Siesta's Agency** ikut daftar? mereka bukan di bidang ekspedisi kan?"

**PR**: "Iya, **Siesta's Agency** ini salah satu perusahaan bergerak di bidang *dragon hunting* (pemburu naga)"

**CTO**: "Waduhh, data kita rusak dong. Apakah kita larang mereka langganan?"

**PR**: "Jangan, itu *bad PR*. Kita terpaksa memperbolehkan mereka langganan :("

**GM**: "Kira-kira buat apa ya mereka langganan sistem ini?"

**PR**: "**BONK**. Sudah jelas untuk tahu lokasi Drago sehingga mereka bisa menyerangnya!"

**GM**: "Ohhh, jadi mereka malah menggunakan API itu untuk hanya pergi ke tempat yang sedang di jaga Drago?"

**CTO**: "Adalah benar. Yah syukurlah kami tidak perlu mengubah apa-apa di sisi API untuk mengakomodasi ide mereka. Yang penting API kami bisa memberikan lokasi Drago secara terpercaya"

*Sisi lain, di perusahaan ekspedisi **Raiden's Lightning Express** ketika PT. DailyNichi mengumumkan API baru*

Terjadi percakapan antara Logistics Manager (LM) dan CEO (Raiden).


**LM**: "Boss, PT. DailyNichi membuka API baru yang menarik nih"

**Raiden**: "Apa itu?"

**LM**: "API notifikasi Drago, boss! Kini kita bisa tahu lokasinya jadi bisa mengambil rute alternatif"

**Raiden**: "Bagus juga idenya, jadi dari 3 rute yang tersedia, kita bisa lewati dua rute lain yang tidak dijaga Drago ya?"

**LM**: "Bener boss"

**Raiden**: "Eh, PT. DailyNichi? Kita bukannya langganan **SweetsMonitor** juga dari mereka? API yang memberi notifikasi jika sedang ada Sweets Festival di salah satu rute?"

**LM**: "Bener boss, kurir kami *sweet tooth* semua boss. Jika sedang ada Sweets Festival, mereka pasti memilih untuk melewati rute tersebut"

**Raiden**: "Kalau misal rute tempat Sweets Festival sedang dijaga Drago juga gimana?"

**LM**: "Sejujurnya Drago tidak masalah boss. kurir kami terkenal karena kecepatan pengirimannya. Karyawan kami biasa mampir di Sweets   Festival, kemudian akan *blitz* melewati Drago jika ketemu. Bahkan Drago biasanya tidak sadar jika kurir kami lewat"

**Raiden**: "Tapi kalau sedang tidak ada Sweets Festival, kurir kami akan menghindari rute yang dijaga Drago kan?"

**LM**: "Iya boss"

## Flow pekerjaan

Pada front-end, akan ada tombol untuk meletakkan Drago dan memulai Sweets festival disemua kemungkinan rute. Ada juga layout untuk setiap pengguna API yang menampilkan rute-rute mana yang dapat dia lalui sekarang. Program dikatakan berhasil apabila tampilan daftar rute-rute yang diambil oleh setiap pengguna API sudah sesuai dengan setiap skenario yang dijelaskan di deskripsi.

## Penjelasan Kode

Pada bagian *core*, ada dua buah interface:

1. Interface **EventsMonitor** untuk menyatakan API-API yang dimiliki oleh PT. DailyNichi (DragoMonitor dan SweetsMonitor)
2. Interface **RoadUser** untuk menyatakan sebuah pengguna API. Dua class yang mengimplementasikannya adalah **Courier** dan **DragoHunter**. Fungsionalitas kedua class ini sesuai dengan deskripsi soal.

Semua entitas untuk keperluan lab akan diinisialisasi di **TrackingInitializer.java**. Hal ini termasuk membuat semua **Courier** dan **DragonHunter**, dan memilih kepada siapa saja mereka berlangganan.