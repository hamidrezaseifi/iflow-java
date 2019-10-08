/**
 *
 */
package com.pth.iflow.common.rest.xml;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author tmenzel
 * @since 14.07.2018
 */
final class BufferedHttpServletRequestWrapper extends HttpServletRequestWrapper {

  private BufferedServletInputStream bufferedServletInputStream;

  /**
   * @author tmenzel
   * @since 14.07.2018
   */
  private final class BufferedServletInputStream extends ServletInputStream {

    private final BufferedInputStream cache;
    private boolean                   finished;
    private final ServletInputStream  wrapped;

    /**
     * @param inputStream
     */
    public BufferedServletInputStream(final ServletInputStream inputStream) {
      this.wrapped = inputStream;
      this.cache = new BufferedInputStream(inputStream);
    }

    @Override
    public int read() throws IOException {
      final int read = cache.read();
      finished = read == -1;
      return read;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.io.InputStream#reset()
     */
    @Override
    public synchronized void reset() throws IOException {
      cache.reset();
      finished = false;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.io.InputStream#mark(int)
     */
    @Override
    public synchronized void mark(final int readlimit) {
      cache.mark(readlimit);
    }

    @Override
    public void setReadListener(final ReadListener readListener) {
      wrapped.setReadListener(readListener);
    }

    @Override
    public boolean isReady() {
      return wrapped.isReady();
    }

    @Override
    public boolean isFinished() {
      return finished;
    }
  }

  /**
   * @param request
   */
  BufferedHttpServletRequestWrapper(final HttpServletRequest request) {
    super(request);
  }

  /**
   * (non-Javadoc)
   *
   * @see javax.servlet.ServletRequestWrapper#getInputStream()
   */
  @Override
  public ServletInputStream getInputStream() throws IOException {
    if (bufferedServletInputStream == null) {
      bufferedServletInputStream = new BufferedServletInputStream(super.getInputStream());
    }

    return bufferedServletInputStream;
  }

}
