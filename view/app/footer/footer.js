import styles from "./footer.module.css"
import Link from 'next/link'

const Footer = () => {
    
    return (
        <div className={"row " + styles.footer}>
            <div className="btn-group" role="group">
                <Link href="social-media-plugins" className={"btn " + styles.footerBtn}>Social Media Plugins</Link>
                <Link href="building-this-app" className={"btn " + styles.footerBtn}>Building This App</Link>
                <Link href="about-me" className={"btn " + styles.footerBtn}>About Me</Link>
                <Link href="contact" className={"btn " + styles.footerBtn}>Contact</Link>
                <Link href="help" className={"btn " + styles.footerBtn}>Help</Link>
            </div>
        </div>
    );
};

export default Footer;