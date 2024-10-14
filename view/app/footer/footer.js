import styles from "./footer.module.css"
import Link from 'next/link'

const Footer = () => {
    
    return (
        <div className={"row " + styles.footer}>
            <div className="btn-group" role="group">
                {/* <button className={"btn " + styles.footerBtn} type="button" 
                        onClick={() => router.push('/social-media-plugins')}>Social Media Plugins</button>
                <button className={"btn " + styles.footerBtn} type="button" 
                        onClick={() => router.push('/building-this-app')}>Building This App</button>
                <button className={"btn " + styles.footerBtn} type="button" 
                        onClick={() => router.push('/help')}>Help</button>
                <button className={"btn " + styles.footerBtn} type="button" 
                        onClick={() => router.push('/contact')}>Contact</button>
                <button className={"btn " + styles.footerBtn} type="button" 
                        onClick={() => router.push('/about-me')}>About Me</button> */}
                <Link href="social-media-plugins" className={"btn " + styles.footerBtn}>Social Media Plugins</Link>
                <Link href="building-this-app" className={"btn " + styles.footerBtn}>Building This App</Link>
                <Link href="help" className={"btn " + styles.footerBtn}>Help</Link>
                <Link href="contact" className={"btn " + styles.footerBtn}>Contact</Link>
                <Link href="about-me" className={"btn " + styles.footerBtn}>About Me</Link>
            </div>
        </div>
    );
};

export default Footer;