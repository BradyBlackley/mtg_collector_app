import styles from "./navigation.module.css"
import Link from 'next/link'

const Navigation = () => {
    return (
        <div className={"row " + styles.navigationBar}>
            <div>
                <Link href="/" className={"btn " + styles.footerBtn}>Home</Link>
                <Link href="/card" className={"btn " + styles.footerBtn}>Card Search</Link>
                <Link href="/types" className={"btn " + styles.footerBtn}>Types</Link>
                <Link href="/expansions" className={"btn " + styles.footerBtn}>Expansions</Link>
                <Link href="/keywords" className={"btn " + styles.footerBtn}>Keywords</Link>
                <Link href="admin" className={"btn " + styles.footerBtn}>Admin</Link>
            </div>
        </div>
    );
};

export default Navigation;