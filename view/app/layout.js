import Banner from "./banner/banner"
import Navigation from "./navigation/navigation"
import Footer from "./footer/footer"
import  "bootstrap/dist/css/bootstrap.min.css"

export default function RootLayout({ children }) {
    return (
      <html lang="en">
        <body>
          <Banner headerText = "Magic The Gathering Collector&apos;s App"/>
          <Navigation />
          <main>{children}</main>
          <Footer />
        </body>
      </html>
    )
  }