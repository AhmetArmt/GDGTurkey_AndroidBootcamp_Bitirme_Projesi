# GDG Turkey Android Bootcamp Bitirme Projesi

### Merhabalar Sevgili GDG Türkiye Ailesi
Öncelikle bu bootcampi hazırlayıp bizlere sunduğunuz için sizelere çok teşekkür ederim. Sizden önce pandemi sürecimi iyi değerlendirmek için girdiğim bu halk arasındaki tabiriyle 'Yazılım Öğrenme' serüvenimde bana  ve arkadaşlarıma çok güzel rehberlik ettiniz. Bootcampin başında Android Studio ve Kotlin hakkında hiçbir bilgim yokken şuanda neler yapabildiğime şaşırıyorum. Önceden Java dilini deneyimlemiş birisi olarak bizi kotlinle tanıştırdığınız için ayrıca teşekkür diyorum.



# Harcama Takip Uygulaması

## Proje'de Neleri kullandım ?

### Retrofit 2 
Retrofit sayesinde internet üzerinden bulduğum ücretsiz ve kayıt şartı gerektirmeyen [bu](https://ratesapi.io/) api'yi kullanarak güncel doviz verilerini internetten çektim. Döviz verileri için ayrı bir Room Database oluşturmadım. bunun yerine bu yapıları Shared Preferences yapısında kaydettim.

#### Room Database
Room Database sayesinde harcama verilerini tutmak ; aynı zamanda bu verileri ekleyip silebilmek için bir sistem oluşturdum. 

#### DataBinding
Uygulamada RecyclerView ve Detay ekranındaki verileri daha kolay organize edebilmek için DataBinding kullandım. Ayrıca XML fonksiyonu oluşturarak resimlerin harcamaların türlerine göre değişklik göstermesini sağladım.

#### Lottie
Splashscreen ve onBoardingscreendeki animasyonlar için Lottie kütüphanesini kullandım.

#### Navigation
fragmentlar arasındaki düznlemeleri sağlamak ve uygulamamnın sadece 1 Activity üzerinden çalışmasını sağlamak için Navigation Kullandım. 

#### MVVM Yapısı
Uygulamada MVVM yapısını kullanmaya çalıştım (ilk defa bu projede kullandığım için çok başarılı olduğumu düşünmüyorm)

### Not !
#### Uygulamayi Google Pixel 2 cihazının çözünürlüğünü referans alarak geliştirdim. Diğer cihazlarda tasarımsal sıkıntılar olabilir.

### Tekrardan Teşekkürler 




