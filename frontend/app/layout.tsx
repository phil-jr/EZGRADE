import NavBar from '@/components/NavBar'
import './globals.css'
import { UserContextProvider } from '@/context/UserContext'

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      {/*
        <head /> will contain the components returned by the nearest parent
        head.tsx. Find out more at https://beta.nextjs.org/docs/api-reference/file-conventions/head
      */}
      <head />
      <body>
      <UserContextProvider>
          <NavBar />
      </UserContextProvider>
        <div className="p-4">
          {children}
        </div>
      </body>
    </html>
  )
}
