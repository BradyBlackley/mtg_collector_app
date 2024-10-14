import styles from "./navigation.module.css"
import Link from 'next/link'

const Navigation = () => {
    return (
        <div className={"row " + styles.navigationBar}>
            <div>
                <Link href="/">Home</Link>
                <Link href="/card-search">Card Search</Link>
                <Link href="/types">Types</Link>
                <Link href="/expansions">Expansions</Link>
                <Link href="/keywords">Keywords</Link>
                <Link href="admin">Admin</Link>
            </div>
        </div>
    );
};

export default Navigation;