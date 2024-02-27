import styles from "./footer.module.css"

const Footer = () => {
    return (
        <div className={"row " + styles.footer}>
            <div className="btn-group" role="group">
                <button className={"btn " + styles.footerBtn}>Social Media Plugins</button>
                <button className={"btn " + styles.footerBtn}>Building This Site</button>
                <button className={"btn " + styles.footerBtn}>Help</button>
                <button className={"btn " + styles.footerBtn}>Contact</button>
                <button className={"btn " + styles.footerBtn}>About Me</button>
            </div>
        </div>
    );
};

export default Footer;