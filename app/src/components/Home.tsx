import Sidebar from "./Sidebar.tsx";

export default function Home() {
    return (
        <>
            <div className="d-flex h-100">
                <Sidebar/>
                <div className={"text-info p-3"}>
                    Some content goes here...
                </div>
            </div>
        </>
    )
}